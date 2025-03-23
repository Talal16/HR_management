package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {
    @Autowired
    private UserService userService;


    @Operation(summary=" create a new user")
    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        System.out.println("CREATE USER YA"+userDto);



        return userService.createUser(userDto);
    }


    @Operation(summary="get user by id")
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return userService.getUser(id);
    }

    @Operation(summary=" update user")
    @PutMapping("/{id}")
    public UserDto updateUser(@Valid @RequestBody UserDto userDto, @PathVariable long id) {
        return userService.updateUser(id, userDto);
    }

    @Operation(summary="delete user")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }


    @Operation(summary = "get all users")
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/test")
    public String test() {System.out.println("test test"); return  "test";}

}
