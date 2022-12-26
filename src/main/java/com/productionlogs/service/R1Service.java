package com.productionlogs.service;

import com.productionlogs.dto.R1Dto;
import com.productionlogs.entity.R1;
import com.productionlogs.repository.R1Repository;
import com.productionlogs.service.mapper.R1Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class R1Service {
    private final R1Repository r1Repository;
    private final R1Mapper r1Mapper;

    public R1Service(R1Repository r1Repository, R1Mapper r1Mapper) {
        this.r1Repository = r1Repository;
        this.r1Mapper = r1Mapper;
    }

    //  TODO adding user here

    public void save(R1 r1) {
        r1Repository.save(r1);
    }

    public R1 map(R1Dto r1Dto) {
        return r1Mapper.mapR1DtoToR1(r1Dto);
    }

    @Transactional(readOnly = true)
    public List<R1> findAll() {
        return r1Repository.findAll();
    }
}