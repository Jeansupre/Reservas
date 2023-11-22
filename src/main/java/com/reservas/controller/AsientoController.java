package com.reservas.controller;

import com.reservas.dto.AsientoDTO;
import com.reservas.mappers.AsientoMapper;
import com.reservas.model.Asiento;
import com.reservas.service.interfaces.IAsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/asiento")
public class AsientoController {

    private final IAsientoService iAsientoService;

    @GetMapping("/find")
    public ResponseEntity<List<AsientoDTO>> findAll(){

        List<Asiento> listaAsientos = this.iAsientoService.findAll();

        if (listaAsientos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(listaAsientos.stream()
                    .map(AsientoMapper.INSTANCE::toAsientoDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @PostMapping("/searchByNombre")
    public ResponseEntity<List<AsientoDTO>> findAsientoByNombre(@RequestBody AsientoDTO asientoDTO){

        var nombre = "%" + asientoDTO.getAsiento() + "%";

        List<Asiento> listaAsientos = this.iAsientoService.findAsientoByNombre(nombre);

        if (listaAsientos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaAsientos.stream()
                    .map(AsientoMapper.INSTANCE::toAsientoDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @PostMapping("/searchByNombreAndIdAvion")
    public ResponseEntity<List<AsientoDTO>> findAsientoByNombreAndIdAvion(
            @RequestBody AsientoDTO asientoDTO
    ){
        String nombre = "%" + asientoDTO.getAsiento() + "%";
        Long idAvion = asientoDTO.getIdAvion();

        List<Asiento> listaAsientos = this.iAsientoService.findAsientoByNombreAndIdAvion(nombre, idAvion);

        if (listaAsientos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaAsientos.stream()
                    .map(AsientoMapper.INSTANCE::toAsientoDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
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
