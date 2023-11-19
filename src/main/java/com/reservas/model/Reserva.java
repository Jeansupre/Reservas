package com.reservas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "reservas", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado_reserva;
    private Float precio_pagado;

    @Column(name = "usuario_id")
    private Long idUsuario;
    @Column(name = "vuelo_id")
    private Long idVuelo;
    @Column(name = "asiento_id")
    private Long idAsiento;

    /*
    @ManyToOne
    @JoinColumn(name = "vuelo_id", referencedColumnName = "id")
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "asiento_id", referencedColumnName = "id")
    private Asiento asiento;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
     */
}
