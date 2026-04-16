package com.postsolicitud.sistema_postulaciones.mapper;


import com.postsolicitud.sistema_postulaciones.dto.PostulacionRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.PostulacionResponseDTO;
import com.postsolicitud.sistema_postulaciones.entidad.Postulacion;
import org.springframework.stereotype.Component;

@Component
public class PostulacionMapper {

    public PostulacionResponseDTO getDTO(Postulacion postulacion) {
        return PostulacionResponseDTO.builder()
                .id(postulacion.getId())
                .nomPuesto(postulacion.getNomPuesto())
                .descripcion(postulacion.getDescripcion())
                .empresa(postulacion.getEmpresa())
                .salario(postulacion.getSalario())
                .estado(postulacion.getEstado())
                .usuarioId(postulacion.getUsuario() != null ? postulacion.getUsuario().getId() : null)
                .build();
    }

    public Postulacion getEntity(PostulacionRequestDTO requestDTO) {
        return Postulacion.builder()
                .nomPuesto(requestDTO.getNomPuesto())
                .descripcion(requestDTO.getDescripcion())
                .salario(requestDTO.getSalario())
                .empresa(requestDTO.getEmpresa())
                .estado(requestDTO.getEstado())
                .build();
    }
}
