package com.reservas.mappers;

import com.reservas.dto.AvionDTO;
import com.reservas.model.Avion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvionMapper {

    AvionMapper INSTANCE = Mappers.getMapper(AvionMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "numero_avion", source = "numero_avion")
    @Mapping(target = "cantidad_asientos", source = "cantidad_asientos")
    AvionDTO toAvionDTO(Avion avion);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "numero_avion", source = "numero_avion")
    @Mapping(target = "cantidad_asientos", source = "cantidad_asientos")
    Avion toAvion(AvionDTO avionDTO);
}
