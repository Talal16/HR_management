package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Lazy;

@Lazy
@Mapper(componentModel = "spring", uses = {RoleMapper.class, DepartmentMapper.class, UserMapper.class})
public interface UserMapper {

    @Mapping(source = "role", target = "role")
    @Mapping(source = "department", target = "department")
    @Mapping(source = "manager", target = "manager")
    @Mapping(source = "phoneNumber", target = "phoneNumber")

    UserDto toDto(User user);

    @Mapping(source = "role", target = "role")
    @Mapping(source = "department", target = "department")
    @Mapping(source = "manager", target = "manager")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    User toEntity(UserDto userDto);
}