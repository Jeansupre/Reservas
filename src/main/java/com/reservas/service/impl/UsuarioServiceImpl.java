package com.reservas.service.impl;

import com.reservas.model.Usuario;
import com.reservas.repository.IUsuarioRepository;
import com.reservas.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository iUsuarioRepository;

    public List<Usuario> findAll(){
        return this.iUsuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return this.iUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario findUsuarioByDocumento(String documento) {
        return this.iUsuarioRepository.findUsuarioByDocumento(documento);
    }

    @Override
    public List<Usuario> findUsuarioByCorreo(String correo) {
        return this.iUsuarioRepository.findUsuarioByCorreo(correo);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return this.iUsuarioRepository.save(usuario);
    }

    @Override
    public Usuario eliminarUsuario(Long id) {
        Usuario aUsuario = this.iUsuarioRepository.findById(id).orElse(null);

        if(aUsuario != null) {
            this.iUsuarioRepository.delete(aUsuario);
        }
        return aUsuario;
    }

    @Autowired
    public UsuarioServiceImpl(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }
}
