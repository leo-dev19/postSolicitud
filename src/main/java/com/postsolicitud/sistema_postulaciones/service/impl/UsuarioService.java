package com.postsolicitud.sistema_postulaciones.service.impl;


import com.postsolicitud.sistema_postulaciones.dto.UsuarioRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.UsuarioResponseDTO;
import com.postsolicitud.sistema_postulaciones.entidad.Usuario;
import com.postsolicitud.sistema_postulaciones.mapper.UsuarioMapper;
import com.postsolicitud.sistema_postulaciones.repository.UsuarioRespository;
import com.postsolicitud.sistema_postulaciones.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRespository usuarioRespository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuarioResponseDTO guardar(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioRequestDTO);
        usuario.setPassword(passwordEncoder.encode(usuarioRequestDTO.getPassword()));

        Usuario nuevo = usuarioRespository.save(usuario);
        return usuarioMapper.toResponseDTO(nuevo);
    }

    @Override
    public UsuarioResponseDTO obtenerPorUsername(String username) {
        Usuario usuario = usuarioRespository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + username));

        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO editarPorUsername(String username, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioRespository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + username));

        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setApellido(usuarioRequestDTO.getApellido());
        usuario.setUsername(usuarioRequestDTO.getUsername());

        if (usuarioRequestDTO.getPassword() != null && !usuarioRequestDTO.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(usuarioRequestDTO.getPassword()));
        }

        Usuario guardado = usuarioRespository.save(usuario);
        return usuarioMapper.toResponseDTO(guardado);
    }

    @Override
    public void eliminarPorUsername(String username) {
        Usuario usuario = usuarioRespository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + username));

        usuarioRespository.delete(usuario);
    }
}