package com.productionlogs.service.mapper;

import com.productionlogs.dto.OperationDto;
import com.productionlogs.entity.Operation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JournalMapper {
    Operation mapR1DtoToR1(OperationDto operationDto);
}
