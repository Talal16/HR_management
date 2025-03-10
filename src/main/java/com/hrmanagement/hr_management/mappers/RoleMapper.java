package com.hrmanagement.hr_management.mappers;


import com.hrmanagement.hr_management.dto.RoleDto;
import com.hrmanagement.hr_management.models.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {

    RoleDto map(Role roleEntity);
    Role map(RoleDto roleDto);
}
