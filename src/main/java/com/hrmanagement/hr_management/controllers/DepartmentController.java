package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.DepartmentDto;
import com.hrmanagement.hr_management.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@Tag(name = "Departments Management", description = "APIs for managing departments ")

public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    //create new department
    @Operation(summary = "create a new department")
    @PostMapping
    public DepartmentDto createDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.createDepartment(departmentDto);
    }

    // get  department by id
    @Operation(summary = "get department by id")
    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    // update department

    @Operation(summary = "update department")
    @PutMapping("/{id}")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable Long id) {
        return departmentService.updateDepartment(id, departmentDto);
    }

    // delete department
    @Operation(summary = "delete department")
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    // get all departments
    @Operation(summary = "get all departments")
    @GetMapping
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("test test");
        return "test";
    }

}
