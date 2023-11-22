package com.reservas.model;

import javax.persistence.*;
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

    @Column(name = "usuario_id")
    private Long idUsuario;
    @Column(name = "vuelo_id")
    private Long idVuelo;
    @Column(name = "asiento_id")
    private Long idAsiento;
    @Column(name = "estado_reserva_id")
    private Long idEstado;
    private Float precio_pagado;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Long idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Long getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Long idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Float getPrecio_pagado() {
        return precio_pagado;
    }

    public void setPrecio_pagado(Float precio_pagado) {
        this.precio_pagado = precio_pagado;
    }
}
