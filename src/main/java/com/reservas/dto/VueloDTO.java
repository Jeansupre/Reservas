package com.reservas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VueloDTO {
    private Long id;
    private String numero_vuelo;
    private String origen;
    private String destino;
    private Date fecha;
    private Time hora;
    private Long cantidad_asientos;
}
