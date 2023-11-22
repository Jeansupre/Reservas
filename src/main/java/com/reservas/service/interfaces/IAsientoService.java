package com.reservas.service.interfaces;

import com.reservas.model.Asiento;

import java.util.List;

public interface IAsientoService {

    List<Asiento> findAll();

    Asiento findById(Long id);

    List<Asiento> findAsientoByNombre(String nombre);

    List<Asiento> findAsientoByNombreAndIdAvion(String nombre, Long idAvion);

    Long findCantidadAsientosDisponiblesByAvion(Long idAvion);

    Long findCantidadAsientosOcupadosByAvion(Long idAvion);
    void crearAsientos(Long cantidad, Long idAvion);

    Asiento asignarAsiento(Long id);
}
