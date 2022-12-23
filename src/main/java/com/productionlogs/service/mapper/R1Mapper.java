package com.productionlogs.service.mapper;

import com.productionlogs.dto.R1Dto;
import com.productionlogs.entity.R1;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface R1Mapper {
    R1 mapR1DtoToR1(R1Dto r1Dto);
}
