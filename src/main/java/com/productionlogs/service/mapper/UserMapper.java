package com.productionlogs.service.mapper;

import com.productionlogs.dto.UserDto;
import com.productionlogs.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapUserDtoToUser(UserDto userDto);
}
