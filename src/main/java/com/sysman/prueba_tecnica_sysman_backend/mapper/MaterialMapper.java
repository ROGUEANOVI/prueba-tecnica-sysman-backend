package com.sysman.prueba_tecnica_sysman_backend.mapper;

import com.sysman.prueba_tecnica_sysman_backend.constants.MapperConstants;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialRequestDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.entity.City;
import com.sysman.prueba_tecnica_sysman_backend.entity.Material;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MapperConstants.SPRING)
public interface MaterialMapper {

    @Mapping(target = MapperConstants.ID, ignore = true)
    @Mapping(target = MapperConstants.CITY, source = MapperConstants.CITY_CODE, qualifiedByName = MapperConstants.MAP_CITY_FROM_CODE)
    Material toEntity(MaterialRequestDTO dto);

    @Mapping(target = MapperConstants.CITY, source = MapperConstants.CITY)
    MaterialResponseDTO toDto(Material entity);

    @Named(MapperConstants.MAP_CITY_FROM_CODE)
    default City mapCityFromCode(String cityCode) {
        if (cityCode == null) return null;
        City city = new City();
        city.setCode(cityCode);
        return city;
    }
}
