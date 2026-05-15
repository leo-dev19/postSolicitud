package com.postsolicitud.sistema_postulaciones.service;

import com.postsolicitud.sistema_postulaciones.dto.PostulacionRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.PostulacionResponseDTO;

import java.util.List;

public interface IPostulacionService {

    List<PostulacionResponseDTO> listarPorUsername(String username);

    PostulacionResponseDTO obtenerPorId(Integer id, String username);

    PostulacionResponseDTO guardar(PostulacionRequestDTO requestDTO, String username);

    PostulacionResponseDTO editar(Integer id, PostulacionRequestDTO requestDTO, String username);

    void eliminar(Integer id, String username);
}
