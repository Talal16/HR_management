package com.hrmanagement.hr_management.mappers;


import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.User;
import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {

    UserDto map(User userEntity);
    User unmap(UserDto userDto) ;
}
