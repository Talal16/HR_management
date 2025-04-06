package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.PermissionDto;
import com.hrmanagement.hr_management.models.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PermissionMapper {

    PermissionDto toDto(Permission permissionEntity);
    Permission toEntity(PermissionDto permissionDto);
}
