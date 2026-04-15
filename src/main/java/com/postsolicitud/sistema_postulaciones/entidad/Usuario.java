package com.postsolicitud.sistema_postulaciones.entidad;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
   private int id;

    @Column(name = "nombre", nullable = false, length = 30)
   private String nombre;

    @Column(name = "apellido", nullable = false, length = 30)
   private String apellido;

    @Column(name = "username", nullable = false)
   private String username;

    @Column(name = "password", nullable = false)
   private String password;
}
