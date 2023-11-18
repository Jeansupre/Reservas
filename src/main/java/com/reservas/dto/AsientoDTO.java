package com.reservas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AsientoDTO {
    private Long id;
    private String asiento;
    private String clase;
    private boolean disponibilidad;
    private Float precio;
}