package com.postsolicitud.sistema_postulaciones.service;

import com.postsolicitud.sistema_postulaciones.dto.UsuarioResponseDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO guardar(UsuarioResponseDTO usuarioResponseDTO);
    UsuarioResponseDTO editar(Integer id, UsuarioResponseDTO usuarioResponseDTO);
    void eliminar(Integer id);

}
