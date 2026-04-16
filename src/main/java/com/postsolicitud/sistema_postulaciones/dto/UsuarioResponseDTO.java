package com.postsolicitud.sistema_postulaciones.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private int id;
    private String nombre;
    private String apellido;
    private String username;
}
