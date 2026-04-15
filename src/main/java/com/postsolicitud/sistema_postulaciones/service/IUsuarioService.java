package com.postsolicitud.sistema_postulaciones.service;

import com.postsolicitud.sistema_postulaciones.entidad.Usuario;
import com.postsolicitud.sistema_postulaciones.entidad.UsuarioDTO;
import com.postsolicitud.sistema_postulaciones.repository.UsuarioRespository;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> listar();
    UsuarioDTO guardar(UsuarioDTO usuarioDTO);
    UsuarioDTO editar(Integer id, UsuarioDTO usuarioDTO);
    void eliminar(Integer id);

}
