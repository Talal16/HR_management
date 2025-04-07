package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * UserController is a REST controller that handles user-related operations.
 * It provides endpoints for creating, retrieving, updating, and deleting users.
 */

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {
    @Autowired
    private UserService userService;




    @Operation(summary=" create a new user")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        System.out.println("CREATE USER YA"+userDto);
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(201).body(createdUser);
    }


    @Operation(summary="get user by id")
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return userService.getUser(id);
    }

    @Operation(summary=" update user")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable long id) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
             }

    @Operation(summary = "Delete user")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();  // No content, since the user is deleted
    }

    @Operation(summary = "get all users")
    @GetMapping

    public ResponseEntity<List<UserDto>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/test")
    public String test() {System.out.println("test test"); return  "test";}

}
