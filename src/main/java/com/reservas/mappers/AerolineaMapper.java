package com.reservas.mappers;

import com.reservas.dto.AerolineaDTO;
import com.reservas.model.Aerolinea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper
public interface AerolineaMapper {
    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    AerolineaDTO toAerolineaDTO(Aerolinea aerolinea);

    /*
    static AerolineaDTO toAerolineaDTO(Aerolinea aerolinea) {
        AerolineaDTO aerolineaDTO = new AerolineaDTO();
        aerolineaDTO.setId(aerolinea.getId());
        aerolineaDTO.setNombre(aerolinea.getNombre());
        return aerolineaDTO;
    }

    static Aerolinea toAerolinea(AerolineaDTO aerolineaDTO) {
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setId(aerolineaDTO.getId());
        aerolinea.setNombre(aerolineaDTO.getNombre());
        return aerolinea;
    }
     */
}