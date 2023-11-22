package com.reservas.mappers;


import com.reservas.dto.AsientoDTO;
import com.reservas.model.Asiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AsientoMapper {

    AsientoMapper INSTANCE = Mappers.getMapper(AsientoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "asiento", source = "asiento")
    @Mapping(target = "clase", source = "clase")
    @Mapping(target = "disponibilidad", source = "disponibilidad")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "idAvion", source = "idAvion")
    AsientoDTO toAsientoDTO(Asiento asiento);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "asiento", source = "asiento")
    @Mapping(target = "clase", source = "clase")
    @Mapping(target = "disponibilidad", source = "disponibilidad")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "idAvion", source = "idAvion")
    Asiento toAsiento(AsientoDTO asientoDTO);
}
