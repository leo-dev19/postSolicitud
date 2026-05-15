package com.postsolicitud.sistema_postulaciones.service.impl;

import com.postsolicitud.sistema_postulaciones.dto.PostulacionRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.PostulacionResponseDTO;
import com.postsolicitud.sistema_postulaciones.entidad.Postulacion;
import com.postsolicitud.sistema_postulaciones.entidad.Usuario;
import com.postsolicitud.sistema_postulaciones.mapper.PostulacionMapper;
import com.postsolicitud.sistema_postulaciones.repository.PostulacionRepository;
import com.postsolicitud.sistema_postulaciones.repository.UsuarioRespository;
import com.postsolicitud.sistema_postulaciones.service.IPostulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostulacionService implements IPostulacionService {

    private final PostulacionRepository postulacionRepository;
    private final UsuarioRespository usuarioRepository;
    private final PostulacionMapper mapper;

    @Override
    public List<PostulacionResponseDTO> listarPorUsername(String username) {
        return postulacionRepository.findByUsuarioUsername(username).stream()
                .map(mapper::getDTO)
                .toList();
    }

    @Override
    public PostulacionResponseDTO obtenerPorId(Integer id, String username) {
        Postulacion postulacion = postulacionRepository.findByIdAndUsuarioUsername(id, username)
                .orElseThrow(() -> new RuntimeException("No existe la postulación con ID: " + id));

        return mapper.getDTO(postulacion);
    }

    @Override
    public PostulacionResponseDTO guardar(PostulacionRequestDTO requestDTO, String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + username));

        Postulacion postulacion = mapper.getEntity(requestDTO);
        postulacion.setUsuario(usuario);

        Postulacion nuevo = postulacionRepository.save(postulacion);
        return mapper.getDTO(nuevo);
    }

    @Override
    public PostulacionResponseDTO editar(Integer id, PostulacionRequestDTO requestDTO, String username) {
        Postulacion existente = postulacionRepository.findByIdAndUsuarioUsername(id, username)
                .orElseThrow(() -> new RuntimeException("No existe la postulación con ID: " + id));

        existente.setNomPuesto(requestDTO.getNomPuesto());
        existente.setDescripcion(requestDTO.getDescripcion());
        existente.setSalario(requestDTO.getSalario());
        existente.setEmpresa(requestDTO.getEmpresa());
        existente.setEstado(requestDTO.getEstado());

        Postulacion guardado = postulacionRepository.save(existente);
        return mapper.getDTO(guardado);
    }

    @Override
    public void eliminar(Integer id, String username) {
        Postulacion postulacion = postulacionRepository.findByIdAndUsuarioUsername(id, username)
                .orElseThrow(() -> new RuntimeException("No existe la postulación con ID: " + id));

        postulacionRepository.delete(postulacion);
    }
}