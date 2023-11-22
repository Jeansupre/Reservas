package com.reservas.service.interfaces;

import com.reservas.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> findAll();

    Usuario findUsuarioById(Long id);
    Usuario findUsuarioByDocumento(String documento);
    List<Usuario> findUsuarioByCorreo(String correo);

    Usuario crearUsuario(Usuario usuario);

    Usuario eliminarUsuario(Long id);
}