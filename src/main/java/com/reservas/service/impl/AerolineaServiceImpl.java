package com.reservas.service.impl;

import com.reservas.model.Aerolinea;
import com.reservas.repository.IAerolineaRepository;
import com.reservas.service.interfaces.IAerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaServiceImpl implements IAerolineaService {

    private final IAerolineaRepository iAerolineaRepository;

    @Override
    public List<Aerolinea> findAll() {
        return this.iAerolineaRepository.findAll();
    }

    @Autowired
    public AerolineaServiceImpl(IAerolineaRepository iAerolineaRepository) {
        this.iAerolineaRepository = iAerolineaRepository;
    }
}
