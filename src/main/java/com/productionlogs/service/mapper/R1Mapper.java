package com.productionlogs.service.mapper;

import com.productionlogs.dto.R1Dto;
import com.productionlogs.entity.R1;
import org.springframework.stereotype.Component;

@Component
public class R1Mapper {
    public R1 mapR1DtoToR1(R1Dto r1Dto) {
        return new R1(r1Dto.getOperationStart(), r1Dto.getOperation(), r1Dto.getOperationFinish());
    }
}
