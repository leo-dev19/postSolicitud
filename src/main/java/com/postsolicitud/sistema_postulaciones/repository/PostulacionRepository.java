package com.postsolicitud.sistema_postulaciones.repository;

import com.postsolicitud.sistema_postulaciones.entidad.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
}
