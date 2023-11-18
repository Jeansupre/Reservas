package com.reservas.controller;

import com.reservas.dto.AerolineaDTO;
import com.reservas.mappers.AerolineaMapper;
import com.reservas.model.Aerolinea;
import com.reservas.service.interfaces.IAerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aerolinea")
public class AerolineaController {

    private final IAerolineaService iAerolineaService;

    @GetMapping("/find")
    public ResponseEntity<List<AerolineaDTO>> findAll(){
        List<Aerolinea> ListaAerolinea = this.iAerolineaService.findAll();

        return new ResponseEntity<>(ListaAerolinea.stream()
                .map(AerolineaMapper.INSTANCE::toAerolineaDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Autowired
    public AerolineaController(IAerolineaService iAerolineaService) {
        this.iAerolineaService = iAerolineaService;
    }
}
