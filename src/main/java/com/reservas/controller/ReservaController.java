package com.reservas.controller;

import com.reservas.model.Reserva;
import com.reservas.service.interfaces.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    private final IReservaService iReservaService;

    @GetMapping("/find")
    public ResponseEntity<List<Reserva>> findAll(){

        List<Reserva> listaReservas = this.iReservaService.findAll();

        if (listaReservas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaReservas, HttpStatus.OK);
        }
    }

    @Autowired
    public ReservaController(IReservaService iReservaService) {
        this.iReservaService = iReservaService;
    }
}
