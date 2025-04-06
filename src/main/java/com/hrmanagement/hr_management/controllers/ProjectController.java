package com.hrmanagement.hr_management.controllers;


import com.hrmanagement.hr_management.dto.ProjectDto;
import com.hrmanagement.hr_management.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/project")
@Tag(name = "{projects} Management", description = "APIs for managing projects")

public class ProjectController {
    @Autowired
    ProjectService projectService;

    //create a new project
    @Operation(summary="create a new project")
    @PostMapping
    public ProjectDto createProject(@Valid @RequestBody ProjectDto projectDto) {
        System.out.println("CREATE PROJECT YA"+projectDto);
        return projectService.createProject(projectDto);
    }

    // update project

    @Operation(summary="update project")
    @PutMapping("/{id}")
    public ProjectDto updateProject(@Valid @RequestBody ProjectDto projectDto, @PathVariable long id) {
        return projectService.updateProject(id, projectDto);
    }
    //GET project by id
    @Operation(summary="get project by id")
    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable long id) {
        return projectService.getProject(id);
    }

    //delete project
    @Operation(summary="delete project")
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
    }


    // get all projects

    @Operation(summary="get all projects")
    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }










}

