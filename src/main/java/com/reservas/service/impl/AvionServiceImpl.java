package com.reservas.service.impl;

import com.reservas.model.Avion;
import com.reservas.repository.IAvionRepository;
import com.reservas.service.interfaces.IAvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImpl implements IAvionService {

    private final IAvionRepository iAvionRepository;

    @Override
    public Avion findAvionById(Long id) {
        return this.iAvionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Avion> findAll() {
        return this.iAvionRepository.findAll();
    }

    @Override
    public List<Avion> findAvionesByAerolinea(Long id) {
        return this.iAvionRepository.findAvionByAerolinea_id(id);
    }

    @Override
    public Avion crearAvion(Avion avion) {
        return this.iAvionRepository.save(avion);
    }

    @Override
    public Avion eliminarAvion(Long id) {
        Avion avion = this.iAvionRepository.findById(id).orElse(null);

        if (avion != null) {
            this.iAvionRepository.delete(avion);
        }
        return avion;
    }

    @Autowired
    public AvionServiceImpl(IAvionRepository iAvionRepository) {
        this.iAvionRepository = iAvionRepository;
    }


}