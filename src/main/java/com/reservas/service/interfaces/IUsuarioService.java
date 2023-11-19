package com.reservas.service.interfaces;

import com.reservas.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> findAll();
}