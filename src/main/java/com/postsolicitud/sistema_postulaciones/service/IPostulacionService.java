package com.postsolicitud.sistema_postulaciones.service;

import com.postsolicitud.sistema_postulaciones.dto.PostulacionRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.PostulacionResponseDTO;
import com.postsolicitud.sistema_postulaciones.entidad.Postulacion;

import java.util.List;

public interface IPostulacionService {
    List<PostulacionResponseDTO> listar();
    PostulacionResponseDTO guardar(PostulacionRequestDTO requestDTO);
    PostulacionResponseDTO editar(Integer id, PostulacionRequestDTO requestDTO);
    void eliminar(Integer id);
}
