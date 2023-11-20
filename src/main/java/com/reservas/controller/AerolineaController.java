package com.reservas.controller;

import com.reservas.model.Aerolinea;
import com.reservas.service.interfaces.IAerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aerolinea")
public class AerolineaController {

    private final IAerolineaService iAerolineaService;

    @GetMapping("/find")
    public ResponseEntity<List<Aerolinea>> findAll(){
        List<Aerolinea> listaAerolinea = this.iAerolineaService.findAll();

        if (listaAerolinea.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(listaAerolinea, HttpStatus.OK);
        }
    }

    @Autowired
    public AerolineaController(IAerolineaService iAerolineaService) {
        this.iAerolineaService = iAerolineaService;
    }
}
