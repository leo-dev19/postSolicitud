package com.postsolicitud.sistema_postulaciones.repository;

import com.postsolicitud.sistema_postulaciones.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}
