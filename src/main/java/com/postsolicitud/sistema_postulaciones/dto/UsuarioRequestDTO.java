package com.postsolicitud.sistema_postulaciones.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 30, message = "El nombre debe ser maximo de 30 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 30, message = "El apellido debe ser maximo de 30 caracteres")
    private String apellido;

    @NotBlank(message = "El username es obligatorio")
    private String username;

    @Size(min = 6, message = "El password debe tener maximo 6 caracteres")
    private String password;
}
