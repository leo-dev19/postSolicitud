package com.postsolicitud.sistema_postulaciones.repository;

import com.postsolicitud.sistema_postulaciones.entidad.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
    List<Postulacion> findByUsuarioUsername(String username);

    Optional<Postulacion> findByIdAndUsuarioUsername(Integer id, String username);
}
