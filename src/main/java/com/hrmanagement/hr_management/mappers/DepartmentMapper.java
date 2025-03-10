package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.DepartmentDto;
import com.hrmanagement.hr_management.models.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    DepartmentDto map(Department departmentEntity);

    Department unmap(DepartmentDto departmentDto);
}

