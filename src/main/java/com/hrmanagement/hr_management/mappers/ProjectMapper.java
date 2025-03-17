package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.ProjectDto;
import com.hrmanagement.hr_management.models.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto toDto(Project projectEntity);
    Project toEntity(ProjectDto projectDto);
}