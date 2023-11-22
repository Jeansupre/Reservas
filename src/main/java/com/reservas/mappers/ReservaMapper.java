package com.reservas.mappers;

import com.reservas.dto.ReservaDTO;
import com.reservas.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "idUsuario", source = "idUsuario")
    @Mapping(target = "idVuelo", source = "idVuelo")
    @Mapping(target = "idAsiento", source = "idAsiento")
    @Mapping(target = "idEstado", source = "idEstado")
    @Mapping(target = "precio_pagado", source = "precio_pagado")
    ReservaDTO toReservaDTO(Reserva reserva);
}
