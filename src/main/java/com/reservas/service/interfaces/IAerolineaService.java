package com.reservas.service.interfaces;

import com.reservas.model.Aerolinea;

import java.util.List;

public interface IAerolineaService {
    List<Aerolinea> findAll();
    Aerolinea findAerolineaById(Long id);
}
