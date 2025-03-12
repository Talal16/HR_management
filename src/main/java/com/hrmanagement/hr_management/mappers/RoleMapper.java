package com.hrmanagement.hr_management.mappers;


import com.hrmanagement.hr_management.dto.RoleDto;
import com.hrmanagement.hr_management.models.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {

    RoleDto toDto(Role roleEntity);
    Role toEntity(RoleDto roleDto);
}
