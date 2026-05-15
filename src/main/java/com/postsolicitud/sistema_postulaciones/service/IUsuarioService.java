package com.postsolicitud.sistema_postulaciones.service;

import com.postsolicitud.sistema_postulaciones.dto.UsuarioRequestDTO;
import com.postsolicitud.sistema_postulaciones.dto.UsuarioResponseDTO;

public interface IUsuarioService {

    UsuarioResponseDTO guardar(UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseDTO obtenerPorUsername(String username);

    UsuarioResponseDTO editarPorUsername(String username, UsuarioRequestDTO usuarioRequestDTO);

    void eliminarPorUsername(String username);
}
