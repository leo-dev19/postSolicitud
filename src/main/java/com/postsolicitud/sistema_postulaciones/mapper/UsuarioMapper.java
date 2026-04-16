package com.postsolicitud.sistema_postulaciones.mapper;

import com.postsolicitud.sistema_postulaciones.dto.UsuarioRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.UsuarioResponseDTO;
import com.postsolicitud.sistema_postulaciones.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .username(usuario.getUsername())
                .build();
    }

    public Usuario toEntity(UsuarioRequestDTO requestDTO) {
        return Usuario.builder()
                .nombre(requestDTO.getNombre())
                .apellido(requestDTO.getApellido())
                .username(requestDTO.getUsername())
                .password(requestDTO.getPassword())
                .build();
    }


}
