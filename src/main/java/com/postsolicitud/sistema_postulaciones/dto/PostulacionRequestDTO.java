package com.postsolicitud.sistema_postulaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostulacionRequestDTO {

    private String nomPuesto;
    private String descripcion;
    private BigDecimal salario;
    private String empresa;
    private String estado;
}
