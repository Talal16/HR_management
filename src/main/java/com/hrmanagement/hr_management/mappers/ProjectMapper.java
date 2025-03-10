package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.ProjectDto;
import com.hrmanagement.hr_management.models.Project;
import org.mapstruct.Mapper;
import org.springframework.security.core.parameters.P;

@Mapper
public interface ProjectMapper {
    ProjectDto map(Project projectEntity);
    Project unmap(ProjectDto projectDto);
}
