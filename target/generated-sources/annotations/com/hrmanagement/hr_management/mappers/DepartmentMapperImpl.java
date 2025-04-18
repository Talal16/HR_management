package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.DepartmentDto;
import com.hrmanagement.hr_management.models.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-07T10:24:13+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto toDto(Department departmentEntity) {
        if ( departmentEntity == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( departmentEntity.getId() );
        departmentDto.setName( departmentEntity.getName() );
        departmentDto.setDescription( departmentEntity.getDescription() );
        departmentDto.setManager( departmentEntity.getManager() );

        return departmentDto;
    }

    @Override
    public Department toEntity(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setName( departmentDto.getName() );
        department.setDescription( departmentDto.getDescription() );
        department.setManager( departmentDto.getManager() );

        return department;
    }
}
