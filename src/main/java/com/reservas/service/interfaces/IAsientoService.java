package com.reservas.service.interfaces;

import com.reservas.model.Asiento;

import java.util.List;

public interface IAsientoService {

    List<Asiento> findAll();

    Long findCantidadAsientosDisponiblesByAvion(Long idAvion);

    Long findCantidadAsientosOcupadosByAvion(Long idAvion);
    void crearAsientos(Long cantidad, Long idAvion);
}
