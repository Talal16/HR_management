package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.PermissionDto;
import com.hrmanagement.hr_management.models.Permission;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-23T09:49:37+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PermissionDto toDto(Permission permissionEntity) {
        if ( permissionEntity == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        if ( permissionEntity.getId() != null ) {
            permissionDto.setId( permissionEntity.getId() );
        }
        permissionDto.setUser( userMapper.toDto( permissionEntity.getUser() ) );
        permissionDto.setStartTime( permissionEntity.getStartTime() );
        permissionDto.setEndTime( permissionEntity.getEndTime() );
        permissionDto.setCreatedAt( permissionEntity.getCreatedAt() );
        permissionDto.setUpdatedAt( permissionEntity.getUpdatedAt() );

        return permissionDto;
    }

    @Override
    public Permission toEntity(PermissionDto permissionDto) {
        if ( permissionDto == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setId( permissionDto.getId() );
        permission.setUser( userMapper.toEntity( permissionDto.getUser() ) );
        permission.setStartTime( permissionDto.getStartTime() );
        permission.setEndTime( permissionDto.getEndTime() );
        permission.setCreatedAt( permissionDto.getCreatedAt() );
        permission.setUpdatedAt( permissionDto.getUpdatedAt() );

        return permission;
    }
}
