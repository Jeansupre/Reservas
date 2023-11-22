package com.reservas.controller;

import com.reservas.dto.UsuarioDTO;
import com.reservas.mappers.UsuarioMapper;
import com.reservas.model.Usuario;
import com.reservas.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @GetMapping("/find")
    public ResponseEntity<List<UsuarioDTO>> findAll(){

        List<Usuario> listaUsuario = this.iUsuarioService.findAll();

        if (listaUsuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaUsuario.stream()
                    .map(UsuarioMapper.INSTANCE::toUsuarioDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UsuarioDTO> findUsuarioById(@PathVariable Long id){

        Usuario usuario = this.iUsuarioService.findUsuarioById(id);

        if(usuario != null){
            return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuario), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/searchByDocumento")
    public ResponseEntity<UsuarioDTO> findUsuarioByDocumento(@RequestBody UsuarioDTO usuarioDTO){

        var documento = usuarioDTO.getDocumento().trim();
        Usuario usuario = this.iUsuarioService.findUsuarioByDocumento(documento);

        if(usuario != null){
            return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuario), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/searchByCorreo")
    public ResponseEntity<List<UsuarioDTO>> findUsuarioByCorreo(@RequestBody UsuarioDTO usuarioDTO){

        var correo = "%" + usuarioDTO.getCorreo().trim() + "%";
        List<Usuario> listUsuario = this.iUsuarioService.findUsuarioByCorreo(correo);

        if(listUsuario != null){
            return new ResponseEntity<>(listUsuario.stream()
                    .map(UsuarioMapper.INSTANCE::toUsuarioDTO)
                    .collect(Collectors.toList()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){

        Usuario aUsuario = UsuarioMapper.INSTANCE.toUsuario(usuarioDTO);

        try {
            Usuario usuarioCreado = this.iUsuarioService.crearUsuario(aUsuario);

            if (usuarioCreado != null){
                return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(usuarioCreado), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarUsuario(@RequestBody UsuarioDTO usuarioDTO){

        var id = usuarioDTO.getId();
        Usuario aUsuario = this.iUsuarioService.eliminarUsuario(id);

        if(aUsuario != null){
            return new ResponseEntity<>(UsuarioMapper.INSTANCE.toUsuarioDTO(aUsuario), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No hay elementos a eliminar",HttpStatus.NO_CONTENT);
        }
    }

    @Autowired
    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }
}
