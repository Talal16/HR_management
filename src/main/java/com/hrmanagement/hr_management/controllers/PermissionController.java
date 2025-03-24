package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.PermissionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.hrmanagement.hr_management.services.PermissionService;
import java.util.List;

@RestController
@RequestMapping ("/api/v1/permissions")
@Tag(name = "Permission Controller", description = "Permission API Endpoints")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    //create new Permission
    @Operation(summary = "Create new Permission")
    @PostMapping
    public PermissionDto createPermission(@RequestBody PermissionDto permissionDto) {
        return permissionService.createPermission(permissionDto);
    }

    //get Permission by id
    @Operation(summary = "Get Permission by ID")
    @GetMapping("/{id}")
    public PermissionDto getPermissionById(@PathVariable Long id) {
        return permissionService.getPermission(id);
    }

    //update
    @Operation(summary = "update permission")
    @PutMapping("/{id}")
    public PermissionDto updatePermission(@PathVariable Long id, @RequestBody PermissionDto permissionDto) {
        return permissionService.updatePermission(id, permissionDto);
    }


    //delete
    @Operation(summary = "delete permission")
    @DeleteMapping("/{id}")
    public void deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
    }

    //get all Permissions
    @Operation(summary = "get all permissions")
    @GetMapping
    public List<PermissionDto> getAllPermissions() {
        return permissionService.getALlPermissions();
    }


}
