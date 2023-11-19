package com.reservas.service.impl;

import com.reservas.model.Asiento;
import com.reservas.repository.IAsientoRepository;
import com.reservas.service.interfaces.IAsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoServiceImpl implements IAsientoService {

    private final IAsientoRepository iAsientoRepository;

    public List<Asiento> findAll(){
        return this.iAsientoRepository.findAll();
    }

    @Autowired
    public AsientoServiceImpl(IAsientoRepository iAsientoRepository) {
        this.iAsientoRepository = iAsientoRepository;
    }
}
