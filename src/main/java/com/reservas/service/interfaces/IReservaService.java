package com.reservas.service.interfaces;

import com.reservas.model.Reserva;

import java.util.List;

public interface IReservaService {

    List<Reserva> findAll();

    Reserva findById(Long id);

    Reserva asignarReserva(Reserva reserva);
}
