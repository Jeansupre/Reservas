package com.reservas.mappers;

import com.reservas.dto.VueloDTO;
import com.reservas.model.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VueloMapper {

    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "numero_vuelo", source = "numero_vuelo")
    @Mapping(target = "origen", source = "origen")
    @Mapping(target = "destino", source = "destino")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "hora", source = "hora")
    VueloDTO toVueloDTO(Vuelo vuelo);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "numero_vuelo", source = "numero_vuelo")
    @Mapping(target = "origen", source = "origen")
    @Mapping(target = "destino", source = "destino")
    @Mapping(target = "fecha", source = "fecha")
    @Mapping(target = "hora", source = "hora")
    Vuelo toVuelo(VueloDTO vueloDTO);
}
