package com.reservas.service.impl;

import com.reservas.model.Vuelo;
import com.reservas.repository.IVueloRepository;
import com.reservas.service.interfaces.IVuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VuelosServiceImpl implements IVuelosService {

    private final IVueloRepository iVueloRepository;

    @Override
    public List<Vuelo> findAll() {
        return this.iVueloRepository.findAll();
    }
    public VuelosServiceImpl(IVueloRepository iVueloRepository) {
        this.iVueloRepository = iVueloRepository;
    }
}
