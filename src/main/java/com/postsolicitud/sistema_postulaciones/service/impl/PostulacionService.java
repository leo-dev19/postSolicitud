package com.postsolicitud.sistema_postulaciones.service.impl;

import com.postsolicitud.sistema_postulaciones.dto.PostulacionRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.PostulacionResponseDTO;
import com.postsolicitud.sistema_postulaciones.entidad.Postulacion;
import com.postsolicitud.sistema_postulaciones.mapper.PostulacionMapper;
import com.postsolicitud.sistema_postulaciones.repository.PostulacionRepository;
import com.postsolicitud.sistema_postulaciones.service.IPostulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PostulacionService implements IPostulacionService {
    private final PostulacionRepository postulacionRepository;
    private final PostulacionMapper mapper;

    @Override
    public List<PostulacionResponseDTO> listar() {
        return postulacionRepository.findAll().stream()
                .map(mapper::getDTO)
                .toList();
    }

    @Override
    public PostulacionResponseDTO guardar(PostulacionRequestDTO requestDTO) {
        Postulacion postulacion = mapper.getEntity(requestDTO);
        Postulacion nuevo = postulacionRepository.save(postulacion);
        return mapper.getDTO(nuevo);
    }

    @Override
    public PostulacionResponseDTO editar(Integer id, PostulacionRequestDTO requestDTO) {
        Postulacion existente = postulacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Personal no encontrado con ID : " + id));
        Postulacion actualizado = mapper.getEntity(requestDTO);
        actualizado.setId(existente.getId());
        Postulacion guardado = postulacionRepository.save(actualizado);
        return mapper.getDTO(guardado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!postulacionRepository.existsById(id)) {
            throw new RuntimeException("No existe la postulacion con ID : " + id);
        }
        postulacionRepository.deleteById(id);
    }

}
