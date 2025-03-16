package com.hrmanagement.hr_management.mappers;


import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {DepartmentMapper.class})
public interface UserMapper {

    UserDto toDto(User userEntity);
    User toEntity(UserDto userDto) ;
}