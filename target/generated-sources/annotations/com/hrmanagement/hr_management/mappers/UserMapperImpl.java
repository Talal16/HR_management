package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T10:31:29+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setRole( roleMapper.toDto( user.getRole() ) );
        userDto.setDepartment( departmentMapper.toDto( user.getDepartment() ) );
        userDto.setManager( toDto( user.getManager() ) );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setHireDate( user.getHireDate() );
        userDto.setCreatedAt( user.getCreatedAt() );
        userDto.setUpdatedAt( user.getUpdatedAt() );

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setRole( roleMapper.toEntity( userDto.getRole() ) );
        user.setDepartment( departmentMapper.toEntity( userDto.getDepartment() ) );
        user.setManager( toEntity( userDto.getManager() ) );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setId( userDto.getId() );
        user.setEmail( userDto.getEmail() );
        user.setName( userDto.getName() );
        user.setPassword( userDto.getPassword() );
        user.setHireDate( userDto.getHireDate() );
        user.setCreatedAt( userDto.getCreatedAt() );
        user.setUpdatedAt( userDto.getUpdatedAt() );

        return user;
    }
}
