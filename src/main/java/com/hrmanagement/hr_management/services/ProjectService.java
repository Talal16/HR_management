package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.ProjectDto;
import com.hrmanagement.hr_management.mappers.ProjectMapper;
import com.hrmanagement.hr_management.models.Project;
import com.hrmanagement.hr_management.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProjectService {

    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ProjectRepository projectRepository;


    // create project
    public ProjectDto createProject(ProjectDto projectDto) {
        return projectMapper.toDto(projectRepository.save(projectMapper.toEntity(projectDto)));
    }


    // update project
    public ProjectDto updateProject(Long id, ProjectDto projectDto) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            System.out.println("project not found");
            return null;
        }
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        return projectMapper.toDto(projectRepository.save(project));

    }
    // delete project
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project == null) {
            System.out.println("project not found");
            return;
        }
        projectRepository.deleteById(id);
    }
    // get project by id

    public ProjectDto getProject(Long id) {
        return projectMapper.toDto(projectRepository.findById(id).orElse(null));
    }

    // get all projects
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(project -> {
            projectDtos.add(projectMapper.toDto(project));
        });
        return projectDtos;
    }




}
