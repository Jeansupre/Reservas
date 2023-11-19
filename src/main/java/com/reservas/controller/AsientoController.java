package com.reservas.controller;

import com.reservas.model.Asiento;
import com.reservas.service.interfaces.IAsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asiento")
public class AsientoController {

    private final IAsientoService iAsientoService;

    @GetMapping("/find")
    public ResponseEntity<List<Asiento>> findAll(){

        List<Asiento> listaAsientos = this.iAsientoService.findAll();

        if (listaAsientos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(listaAsientos, HttpStatus.OK);
        }
    }

    @Autowired
    public AsientoController(IAsientoService iAsientoService) {
        this.iAsientoService = iAsientoService;
    }
}
