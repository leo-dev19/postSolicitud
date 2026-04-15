package com.postsolicitud.sistema_postulaciones.entidad;


import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class PostulacionDTO {

    private int id;
    private String nomPuesto;
    private String descripcion;
    private BigDecimal salario;
    private String empresa;
    private String estado;

}
