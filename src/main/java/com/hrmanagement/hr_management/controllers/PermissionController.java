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
    //get all permissions by user id
    @Operation(summary = "get all permissions by user id")
    @GetMapping("/user/{userId}")
    public List<PermissionDto> getAllPermissionsByUserId(@PathVariable Long userId) {
        return permissionService.getAllPermissionsByUserId(userId);
    }
    //get all permissions by user id and status
    @Operation(summary = "get all permissions by user id and status")
    @GetMapping("/user/{userId}/status/{status}")
    public List<PermissionDto> getAllPermissionsByUserIdAndStatus(@PathVariable Long userId, @PathVariable String status) {
        return permissionService.getAllPermissionsByUserIdAndStatus(userId, status);
    }
    //get all permissions by status
    @Operation(summary = "get all permissions by status")
    @GetMapping("/status/{status}")
    public List<PermissionDto> getAllPermissionsByStatus(@PathVariable String status) {
        return permissionService.getAllPermissionsByStatus(status);
    }
    //get all permissions by user id and start time
    @Operation(summary = "get all permissions by user id and start time")
    @GetMapping("/user/{userId}/startTime/{startTime}/endTime/{endTime}")
    public List<PermissionDto> getAllPermissionsByUserIdAndStartTimeBetween(@PathVariable Long userId, @PathVariable String startTime, @PathVariable String endTime) {
        return permissionService.getAllPermissionsByUserIdAndStartTimeBetween(userId, startTime, endTime);
    }
    //get all permissions by user id and status and start time
    @Operation(summary = "get all permissions by user id and status and start time")
    @GetMapping("/user/{userId}/status/{status}/startTime/{startTime}/endTime/{endTime}")
    public List<PermissionDto> getAllPermissionsByUserIdAndStatusAndStartTimeBetween(@PathVariable Long userId, @PathVariable String status, @PathVariable String startTime, @PathVariable String endTime) {
        return permissionService.getAllPermissionsByUserIdAndStatusAndStartTimeBetween(userId, status, startTime, endTime);
    }
    //get all permissions by status and start time
    @Operation(summary = "get all permissions by status and start time")
    @GetMapping("/status/{status}/startTime/{startTime}/endTime/{endTime}")
    public List<PermissionDto> getAllPermissionsByStatusAndStartTimeBetween(@PathVariable String status, @PathVariable String startTime, @PathVariable String endTime) {
        return permissionService.getAllPermissionsByStatusAndStartTimeBetween(status, startTime, endTime);
    }
    //get all permissions by start time
    @Operation(summary = "get all permissions by start time")
    @GetMapping("/startTime/{startTimeBegin}/endTime/{startTimeEnd}")
    public List<PermissionDto> getAllPermissionsByStartTimeBetween(@PathVariable String startTime, @PathVariable String endTime) {
        return permissionService.getAllPermissionsByStartTimeBetween(startTime, endTime);
    }







}
