package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.DepartmentDto;
import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.mappers.DepartmentMapper;
import com.hrmanagement.hr_management.mappers.UserMapper;
import com.hrmanagement.hr_management.models.Department;
import com.hrmanagement.hr_management.models.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    private final UserMapper userMapper;
    private final DepartmentMapper departmentMapper;

    public MappingService(@Lazy UserMapper userMapper, @Lazy DepartmentMapper departmentMapper) { // ✅ Use @Lazy to break cycle
        this.userMapper = userMapper;
        this.departmentMapper = departmentMapper;
    }

    public UserDto toUserDto(User user) {
        return userMapper.toDto(user);
    }

    public User toUserEntity(UserDto userDto) {
        return userMapper.toEntity(userDto);
    }

    public DepartmentDto toDepartmentDto(Department department) {
        return departmentMapper.toDto(department);
    }

    public Department toDepartmentEntity(DepartmentDto departmentDto) {
        return departmentMapper.toEntity(departmentDto);
    }
}
