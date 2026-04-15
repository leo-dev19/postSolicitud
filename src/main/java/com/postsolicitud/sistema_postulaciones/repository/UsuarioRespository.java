package com.postsolicitud.sistema_postulaciones.repository;

import com.postsolicitud.sistema_postulaciones.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {
}
