package com.reservas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "asientos")
@AllArgsConstructor
@NoArgsConstructor
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_asiento")
    private String asiento;
    private String clase;
    private boolean disponibilidad;
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "vuelo_id",referencedColumnName = "id")
    private Vuelo vuelo;
}
