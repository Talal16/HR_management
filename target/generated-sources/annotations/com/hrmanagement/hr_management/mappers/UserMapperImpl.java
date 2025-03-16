package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.RoleDto;
import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.Role;
import com.hrmanagement.hr_management.models.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T09:56:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public UserDto toDto(User userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setName( userEntity.getName() );
        userDto.setPassword( userEntity.getPassword() );
        userDto.setEmail( userEntity.getEmail() );
        userDto.setRole( roleToRoleDto( userEntity.getRole() ) );
        userDto.setDepartment( departmentMapper.toDto( userEntity.getDepartment() ) );
        userDto.setManager( toDto( userEntity.getManager() ) );
        userDto.setHireDate( userEntity.getHireDate() );
        userDto.setCreatedAt( userEntity.getCreatedAt() );
        userDto.setUpdatedAt( userEntity.getUpdatedAt() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setEmail( userDto.getEmail() );
        user.setName( userDto.getName() );
        user.setPassword( userDto.getPassword() );
        user.setRole( roleDtoToRole( userDto.getRole() ) );
        user.setDepartment( departmentMapper.toEntity( userDto.getDepartment() ) );
        user.setManager( toEntity( userDto.getManager() ) );
        user.setHireDate( userDto.getHireDate() );
        user.setCreatedAt( userDto.getCreatedAt() );
        user.setUpdatedAt( userDto.getUpdatedAt() );

        return user;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setRoleName( role.getRoleName() );

        return roleDto;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setRoleName( roleDto.getRoleName() );

        return role;
    }
}
