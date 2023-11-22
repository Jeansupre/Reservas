package com.reservas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvionDTO {

    private Long id;
    private String numero_avion;
    private Long cantidad_asientos;
    private Long aerolinea_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_avion() {
        return numero_avion;
    }

    public void setNumero_avion(String numero_avion) {
        this.numero_avion = numero_avion;
    }

    public Long getCantidad_asientos() {
        return cantidad_asientos;
    }

    public void setCantidad_asientos(Long cantidad_asientos) {
        this.cantidad_asientos = cantidad_asientos;
    }

    public Long getAerolinea_id() {
        return aerolinea_id;
    }

    public void setAerolinea_id(Long aerolinea_id) {
        this.aerolinea_id = aerolinea_id;
    }
}
