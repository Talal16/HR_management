package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.ProjectDto;
import com.hrmanagement.hr_management.models.Project;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T09:56:16+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto toDto(Project projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( projectEntity.getId() );
        projectDto.setName( projectEntity.getName() );
        projectDto.setDescription( projectEntity.getDescription() );

        return projectDto;
    }

    @Override
    public Project toEntity(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDto.getId() );
        project.setName( projectDto.getName() );
        project.setDescription( projectDto.getDescription() );

        return project;
    }
}
