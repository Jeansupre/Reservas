package com.reservas.controller;

import com.reservas.dto.AerolineaDTO;
import com.reservas.mappers.AerolineaMapper;
import com.reservas.model.Aerolinea;
import com.reservas.service.interfaces.IAerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Aerolinea> listaAerolinea = this.iAerolineaService.findAll();

        if (listaAerolinea.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(listaAerolinea.stream()
                    .map(AerolineaMapper.INSTANCE::toAerolineaDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findAerolineaById(@PathVariable Long id){

        Aerolinea aerolinea = this.iAerolineaService.findAerolineaById(id);

        if(aerolinea != null){
            return new ResponseEntity<>(AerolineaMapper.INSTANCE.toAerolineaDTO(aerolinea), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Autowired
    public AerolineaController(IAerolineaService iAerolineaService) {
        this.iAerolineaService = iAerolineaService;
    }
}
