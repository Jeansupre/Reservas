package com.reservas.controller;

import com.reservas.dto.ReservaDTO;
import com.reservas.mappers.ReservaMapper;
import com.reservas.model.Asiento;
import com.reservas.model.Reserva;
import com.reservas.service.interfaces.IAsientoService;
import com.reservas.service.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    private final IReservaService iReservaService;
    private final IAsientoService iAsientoService;

    @GetMapping("/find")
    public ResponseEntity<List<Reserva>> findAll(){

        List<Reserva> listaReservas = this.iReservaService.findAll();

        if (listaReservas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaReservas, HttpStatus.OK);
        }
    }

    @PostMapping("searchById")
    public ResponseEntity<ReservaDTO> findById(@RequestBody ReservaDTO reservaDTO){
        Long id = reservaDTO.getId();

        Reserva reserva = this.iReservaService.findById(id);
        if (reserva != null){
            return new ResponseEntity<>(ReservaMapper.INSTANCE.toReservaDTO(reserva), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/hacerReserva")
    public ResponseEntity<?> hacerReserva(
            @RequestBody ReservaDTO reservaDTO){

        Reserva reserva = new Reserva();
        Asiento asiento = this.iAsientoService.findById(reservaDTO.getIdAsiento());

        reserva.setIdUsuario(reservaDTO.getIdUsuario());
        reserva.setIdVuelo(reservaDTO.getIdVuelo());
        reserva.setIdAsiento(reservaDTO.getIdAsiento());
        reserva.setIdEstado(reservaDTO.getIdEstado());
        reserva.setPrecio_pagado(asiento.getPrecio());

        try {
            Reserva reservaHecha = this.iReservaService.asignarReserva(reserva);
            this.iAsientoService.asignarAsiento(reserva.getIdAsiento());
            return new ResponseEntity<>(ReservaMapper.INSTANCE.toReservaDTO(reservaHecha), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/cancelarReserva")
    public ResponseEntity<?> cancelarReserva(@RequestBody ReservaDTO reservaDTO){

        Long id = reservaDTO.getId();

        Reserva reserva = this.iReservaService.findById(id);
        reserva.setIdEstado(2L);

        try{
            Reserva reservaCancelada = this.iReservaService.asignarReserva(reserva);
            return new ResponseEntity<>(ReservaMapper.INSTANCE.toReservaDTO(reservaCancelada), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }

    @Autowired
    public ReservaController(IReservaService iReservaService, IAsientoService iAsientoService) {
        this.iReservaService = iReservaService;
        this.iAsientoService = iAsientoService;
    }
}
