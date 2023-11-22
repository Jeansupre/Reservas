package com.reservas.controller;

import com.reservas.dto.AsientoDTO;
import com.reservas.model.Asiento;
import com.reservas.service.interfaces.IAsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/cantidadAsientosDisp")
    public ResponseEntity<?> findCantidadAsientosDisponiblesByAvion(@RequestBody AsientoDTO asientoDTO){
        var id = asientoDTO.getIdAvion();

        Long cantidad = this.iAsientoService.findCantidadAsientosDisponiblesByAvion(id);

        if (cantidad == 0){
            return new ResponseEntity<>("No hay sillas disponibles", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Hay " + cantidad +" sillas disponibles", HttpStatus.OK);
    }

    @PostMapping("/cantidadAsientosOcup")
    public ResponseEntity<?> findCantidadAsientosOcupadasByAvion(@RequestBody AsientoDTO asientoDTO){
        var id = asientoDTO.getIdAvion();

        Long cantidad = this.iAsientoService.findCantidadAsientosOcupadosByAvion(id);

        if (cantidad == 0){
            return new ResponseEntity<>("No hay sillas ocupadas", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Hay " + cantidad +" sillas ocupadas", HttpStatus.OK);
    }

    @Autowired
    public AsientoController(IAsientoService iAsientoService) {
        this.iAsientoService = iAsientoService;
    }
}
