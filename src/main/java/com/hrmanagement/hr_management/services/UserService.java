package com.hrmanagement.hr_management.services;


import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.mappers.DepartmentMapper;
import com.hrmanagement.hr_management.mappers.RoleMapper;
import com.hrmanagement.hr_management.mappers.UserMapper;
import com.hrmanagement.hr_management.models.User;
import com.hrmanagement.hr_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    public UserDto createUser(UserDto userDto) {
        //check if user exists using email
        // if user exists, throw exception

        User user = userMapper.toEntity(userDto);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
           user.setPassword("P@ssw0rd");
        }

        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        // update user
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
           // throwNotFoundException();
            System.out.println("user not found");
            return null;
        }
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(roleMapper.toEntity(userDto.getRole()));
        user.setDepartment(departmentMapper.toEntity(userDto.getDepartment()));
        user.setManager(userMapper.toEntity(userDto.getManager()));
        user.setHireDate(userDto.getHireDate());

        //updatedUser.setPassword(userDto.getPassword());

        return userMapper.toDto(userRepository.save(user));

    }

    public void deleteUser(Long id) {
       User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            //throwNotFoundException();
            System.out.println("user not found");
            return;
        }
        userRepository.delete(user);
    }

    public UserDto getUser(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }


    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        users.forEach(user->{usersDto.add(userMapper.toDto(user));});

        return usersDto;
    }
}
