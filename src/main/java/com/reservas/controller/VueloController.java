package com.reservas.controller;


import com.reservas.dto.VueloDTO;
import com.reservas.mappers.VueloMapper;
import com.reservas.model.Aerolinea;
import com.reservas.model.Vuelo;
import com.reservas.service.interfaces.IAerolineaService;
import com.reservas.service.interfaces.IVuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vuelo")
public class VueloController {

    private final IVuelosService iVuelosService;
    private final IAerolineaService iAerolineaService;

    @GetMapping("/find")
    public ResponseEntity<List<VueloDTO>> findAll(){

        List<Vuelo> listaVuelo = this.iVuelosService.findAll();

        if(listaVuelo.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaVuelo.stream()
                    .map(VueloMapper.INSTANCE::toVueloDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @GetMapping("search/{id}")
    public ResponseEntity<VueloDTO> findVueloById(@PathVariable Long id){

        Vuelo vuelo = this.iVuelosService.findVueloById(id);

        if (vuelo == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(VueloMapper.INSTANCE.toVueloDTO(vuelo), HttpStatus.OK);
        }
    }

    @PostMapping("searchByAerolinea")
    public ResponseEntity<List<VueloDTO>> findVuelosByAerolinea(@RequestBody VueloDTO vueloDTO){

        var idAerolinea = vueloDTO.getIdAerolinea();

        List<Vuelo> listaVuelosByAerolinea = this.iVuelosService.findVuelosByAerolinea(idAerolinea);


        if (listaVuelosByAerolinea.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaVuelosByAerolinea.stream()
                    .map(VueloMapper.INSTANCE::toVueloDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @PutMapping("/crear")
    public ResponseEntity<?> crearVuelo(@RequestBody VueloDTO vueloDTO){

        Vuelo vuelo = VueloMapper.INSTANCE.toVuelo(vueloDTO);

        try {
            Vuelo vueloCreado = this.iVuelosService.crearVuelo(vuelo);
            return new ResponseEntity<>(VueloMapper.INSTANCE.toVueloDTO(vueloCreado), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarVuelo(@RequestBody VueloDTO vueloDTO){

        var id = vueloDTO.getId();

        Vuelo vueloEliminado = this.iVuelosService.eliminarVuelo(id);
        if(vueloEliminado != null) {
            return new ResponseEntity<>(VueloMapper.INSTANCE.toVueloDTO(vueloEliminado), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No hay elementos a eliminar", HttpStatus.NO_CONTENT);
        }
    }

    @Autowired
    public VueloController(IVuelosService iVuelosService, IAerolineaService iAerolineaService) {
        this.iVuelosService = iVuelosService;
        this.iAerolineaService = iAerolineaService;
    }
}
