package com.reservas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "aerolineas", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 8796254867837083718L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}
