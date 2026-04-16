package com.postsolicitud.sistema_postulaciones.dto;


import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class PostulacionResponseDTO {

    private int id;
    private String nomPuesto;
    private String descripcion;
    private BigDecimal salario;
    private String empresa;
    private String estado;
    private Integer usuarioId;

}
