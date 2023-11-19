package com.reservas.controller;

import com.reservas.model.Usuario;
import com.reservas.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @GetMapping("/find")
    public ResponseEntity<List<Usuario>> findAll(){

        List<Usuario> listaUsuario = this.iUsuarioService.findAll();

        if (listaUsuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
        }
    }

    @Autowired
    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }
}
