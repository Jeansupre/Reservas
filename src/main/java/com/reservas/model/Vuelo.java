package com.reservas.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "vuelos", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero_vuelo;
    private String origen;
    private String destino;
    private Date fecha;
    private Time hora;
    @Column(name = "aerolinea_id")
    private Long idAerolinea;

    /*
    @ManyToOne
    @JoinColumn(name = "aerolinea_id", referencedColumnName = "id")
    private Aerolinea aerolinea;
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_vuelo() {
        return numero_vuelo;
    }

    public void setNumero_vuelo(String numero_vuelo) {
        this.numero_vuelo = numero_vuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Long getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Long idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
}