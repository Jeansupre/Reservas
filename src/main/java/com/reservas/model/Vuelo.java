package com.reservas.model;

import jakarta.persistence.*;
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
    private Long cantidad_asientos;
    @Column(name = "aerolinea_id")
    private Long idAerolinea;

    /*
    @ManyToOne
    @JoinColumn(name = "aerolinea_id", referencedColumnName = "id")
    private Aerolinea aerolinea;
    */
}