package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.DepartmentDto;
import com.hrmanagement.hr_management.models.Department;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Lazy;

@Lazy
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface DepartmentMapper {

    DepartmentDto toDto(Department departmentEntity);

    Department toEntity(DepartmentDto departmentDto);
}

