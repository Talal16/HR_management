package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, DepartmentMapper.class, UserMapper.class})
public interface UserMapper {

    @Mapping(source = "role", target = "role")
    @Mapping(source = "department", target = "department")
    @Mapping(source = "manager", target = "manager")
    UserDto toDto(User user);

    @Mapping(source = "role", target = "role")
    @Mapping(source = "department", target = "department")
    @Mapping(source = "manager", target = "manager")
    User toEntity(UserDto userDto);
}