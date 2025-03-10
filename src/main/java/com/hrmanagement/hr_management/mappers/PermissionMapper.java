package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.PermissionDto;
import com.hrmanagement.hr_management.models.Permission;
import org.mapstruct.Mapper;

@Mapper
public interface PermissionMapper {


    PermissionDto map(Permission permissionEntity);
    Permission unmap(PermissionDto permissionDto);
}
