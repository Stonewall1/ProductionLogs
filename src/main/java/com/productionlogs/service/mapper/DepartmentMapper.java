package com.productionlogs.service.mapper;

import com.productionlogs.dto.DepartmentDto;
import com.productionlogs.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department mapDepartmentDtoToDepartment(DepartmentDto departmentDto);
}
