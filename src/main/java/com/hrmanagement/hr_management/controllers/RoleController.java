package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.RoleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hrmanagement.hr_management.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@Tag(name = "Role Management", description = "APIs for managing Roles")

public class RoleController {
    @Autowired
    private RoleService roleService;

    //create new role
    @Operation(summary="create new role")
    @PostMapping
    public RoleDto createRole(@Valid @RequestBody RoleDto roleDto) {
        System.out.println("CREATE ROLE YA"+roleDto);
        return roleService.createRole(roleDto);
    }

    //get role by id
    @Operation(summary="get role by id")
    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable long id) {
        return roleService.getRole(id);
    }

    //update role
    @Operation(summary="update role")
    @PostMapping("/{id}")
    public RoleDto updateRole(@Valid @RequestBody RoleDto roleDto,@PathVariable long id) {
        return roleService.updateRole(roleDto, id);
    }

    //delete role
    @Operation(summary="delete role")
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);
    }

    //get all roles
    @Operation(summary="get all roles")
    @GetMapping
    public List<RoleDto> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/test")
    public String test() {System.out.println("test test"); return  "test";}
}
