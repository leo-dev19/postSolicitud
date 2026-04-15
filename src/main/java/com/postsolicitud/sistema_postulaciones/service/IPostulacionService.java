package com.postsolicitud.sistema_postulaciones.service;

import com.postsolicitud.sistema_postulaciones.entidad.PostulacionDTO;

import java.util.List;

public interface IPostulacionService {
    List<PostulacionDTO> listar();
    PostulacionDTO guardar(PostulacionDTO postulacionDTO);
    PostulacionDTO editar(Integer id, PostulacionDTO postulacionDTO);
    void eliminar(Integer id);
}
