package com.reservas.service.interfaces;

import com.reservas.model.Vuelo;

import java.util.List;

public interface IVuelosService {

    List<Vuelo> findAll();
}