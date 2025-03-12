package com.hrmanagement.hr_management.mappers;


import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toEntity(User userEntity);
    User toDto(UserDto userDto) ;
}