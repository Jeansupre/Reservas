package com.reservas.service.interfaces;

import com.reservas.model.Avion;

import java.util.List;

public interface IAvionService {

    Avion findAvionById(Long id);
    List<Avion> findAll();

    List<Avion> findAvionesByAerolinea(Long id);

    Avion crearAvion(Avion avion);

    Avion eliminarAvion(Long id);
}
