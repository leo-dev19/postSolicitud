package com.postsolicitud.sistema_postulaciones.entidad;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellido;
}
