package com.reservas.controller;


import com.reservas.model.Vuelo;
import com.reservas.service.interfaces.IVuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vuelo")
public class VueloController {

    private final IVuelosService iVuelosService;

    @GetMapping("/find")
    public ResponseEntity<List<Vuelo>> findAll(){

        List<Vuelo> listaVuelo = this.iVuelosService.findAll();

        if(listaVuelo.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaVuelo, HttpStatus.OK);
        }
    }

    @Autowired
    public VueloController(IVuelosService iVuelosService) {
        this.iVuelosService = iVuelosService;
    }
}
