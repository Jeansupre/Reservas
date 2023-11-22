package com.reservas.service.impl;

import com.reservas.model.Reserva;
import com.reservas.repository.IReservaRepository;
import com.reservas.service.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    private final IReservaRepository iReservaRepository;

    public List<Reserva> findAll(){
        return this.iReservaRepository.findAll();
    }

    @Override
    public Reserva findById(Long id) {
        return this.iReservaRepository.findById(id).orElse(null);
    }

    @Override
    public Reserva asignarReserva(Reserva reserva) {
        return this.iReservaRepository.save(reserva);
    }

    @Autowired
    public ReservaServiceImpl(IReservaRepository iReservaRepository) {
        this.iReservaRepository = iReservaRepository;
    }
}
