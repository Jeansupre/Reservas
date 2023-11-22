package com.reservas.service.interfaces;

import com.reservas.model.Vuelo;

import java.util.List;

public interface IVuelosService {

    List<Vuelo> findAll();

    Vuelo findVueloById(Long id);
    List<Vuelo> findVuelosByAerolinea(Long id);

    Vuelo crearVuelo(Vuelo vuelo);

    Vuelo eliminarVuelo(Long id);
}