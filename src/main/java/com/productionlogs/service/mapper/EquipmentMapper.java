package com.productionlogs.service.mapper;

import com.productionlogs.dto.EquipmentDto;
import com.productionlogs.entity.Equipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    Equipment mapEquipmentDtoToEquipment(EquipmentDto equipmentDto);
}
