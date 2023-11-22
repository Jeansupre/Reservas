package com.reservas.mappers;

import com.reservas.dto.UsuarioDTO;
import com.reservas.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "documento", source = "documento")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "correo", source = "correo")
    UsuarioDTO toUsuarioDTO(Usuario usuario);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "documento", source = "documento")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "correo", source = "correo")
    Usuario toUsuario(UsuarioDTO usuarioDTO);
}
