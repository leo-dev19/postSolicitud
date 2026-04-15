package com.postsolicitud.sistema_postulaciones.entidad;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "tb_postulacion")
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
   private int id;

    @Column(name = "nom_puesto", nullable = false, length = 50)
   private String nomPuesto;

    @Column(name = "descripcion", nullable = false, length = 100)
   private String descripcion;

    @Column(name = "salario", nullable = false)
   private BigDecimal salario;

    @Column(nullable = false)
   private String empresa;

   private String estado;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Usuario usuario;
}