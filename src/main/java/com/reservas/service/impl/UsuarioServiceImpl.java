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

    @Autowired
    public UsuarioServiceImpl(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }
}
