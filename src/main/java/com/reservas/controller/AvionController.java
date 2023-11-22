package com.reservas.controller;

import com.reservas.dto.AvionDTO;
import com.reservas.mappers.AvionMapper;
import com.reservas.model.Avion;
import com.reservas.service.interfaces.IAsientoService;
import com.reservas.service.interfaces.IAvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/avion")
public class AvionController {

    private final IAvionService iAvionService;
    private final IAsientoService iAsientoService;

    @GetMapping("/find")
    public ResponseEntity<List<AvionDTO>> findAll(){

        List<Avion> listAvion = this.iAvionService.findAll();

        if (listAvion != null){
            return new ResponseEntity<>(listAvion.stream()
                    .map(AvionMapper.INSTANCE::toAvionDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/searchById")
    public ResponseEntity<?> findAvionById(@RequestBody AvionDTO avionDTO){

        var id = avionDTO.getId();

        Avion avion = this.iAvionService.findAvionById(id);

        if (avion != null){
            return new ResponseEntity<>(AvionMapper.INSTANCE.toAvionDTO(avion), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No se encontraron elementos", HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/searchByAerolinea")
    public ResponseEntity<List<AvionDTO>> findAvionesByAerolinea(@RequestBody AvionDTO avionDTO){

        var idAero = avionDTO.getAerolinea_id();

        List<Avion> listAvionesByAero = this.iAvionService.findAvionesByAerolinea(idAero);

        if (!listAvionesByAero.isEmpty()){
            return new ResponseEntity<>(listAvionesByAero.stream()
                    .map(AvionMapper.INSTANCE::toAvionDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/crear")
    public ResponseEntity<?> crearAvion(@RequestBody AvionDTO avionDTO){

        if (avionDTO.getNumero_avion() == null || avionDTO.getCantidad_asientos() == null
                || avionDTO.getAerolinea_id() == null){
            return new ResponseEntity<>("Todas las propiedades deben ser definidas", HttpStatus.CONFLICT);
        }

        Avion avion = AvionMapper.INSTANCE.toAvion(avionDTO);

        try {
            Avion avionCreado = this.iAvionService.crearAvion(avion);
            this.iAsientoService.crearAsientos(avion.getCantidad_asientos(), avion.getId());
            return new ResponseEntity<>(AvionMapper.INSTANCE.toAvionDTO(avionCreado), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarAvion(@RequestBody AvionDTO avionDTO){

        var id = avionDTO.getId();
        Avion avion = this.iAvionService.eliminarAvion(id);

        if (avion != null){
            return new ResponseEntity<>(AvionMapper.INSTANCE.toAvionDTO(avion), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No se encontró nignun elemento a eliminar", HttpStatus.NO_CONTENT);
        }
    }

    @Autowired
    public AvionController(IAvionService iAvionService, IAsientoService iAsientoService) {
        this.iAvionService = iAvionService;
        this.iAsientoService = iAsientoService;
    }
}
