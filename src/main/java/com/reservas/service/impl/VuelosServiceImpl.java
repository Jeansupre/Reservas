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

    @Override
    public Vuelo findVueloById(Long id) {
        return this.iVueloRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vuelo> findVuelosByAerolinea(Long id) {
        return this.iVueloRepository.findVuelosByIdAerolinea(id);
    }

    @Override
    public Vuelo crearVuelo(Vuelo vuelo) {
        return this.iVueloRepository.save(vuelo);
    }

    @Override
    public Vuelo eliminarVuelo(Long id) {

        Vuelo eliminarVuelo = this.iVueloRepository.findById(id).orElse(null);

        if (eliminarVuelo != null) {
            this.iVueloRepository.delete(eliminarVuelo);
        }
        return eliminarVuelo;
    }

    public VuelosServiceImpl(IVueloRepository iVueloRepository) {
        this.iVueloRepository = iVueloRepository;
    }
}
