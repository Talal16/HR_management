package com.hrmanagement.hr_management.services;


import com.hrmanagement.hr_management.dto.DepartmentDto;
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

    @Autowired
    private DepartmentService departmentService;

    public UserDto createUser(UserDto userDto) {
        //check if user exists using email
        // if user exists, throw exception
        User userCheck = userRepository.findUserByEmail(userDto.getEmail());
        if (userCheck == null) {
            // ->> throw error user exist
            System.out.println("user email exist");//need to remove
        }

        // check department exist
        // check manager exist


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
            return null; // MUST EDIT
        }
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
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

    // ----> create a userUpdate nullable options for better practice.

    public UserDto userDepartmentTransfer(Long id, Long newDepartmentId) {
        User user =userRepository.findById(id).orElse(null);

        // user not found handling
        if (user == null) {
            //throw new Exception("user not found");
            return null; //Must edit
        }
        //department not found handling
        DepartmentDto  departmentDto =  departmentService.getDepartmentById(newDepartmentId);
        if (departmentDto == null){
            return null;
        }

        //change user department to new department id
        user.setDepartment(departmentMapper.toEntity(departmentDto));
        return userMapper.toDto(userRepository.save(user));
    }
    // --- -- ---
    //------------------------------inDepth---------------------
    // get users by depatrment
    public List<UserDto> getUsersByDepartmentId(Long departmentId){
        List<User> users  = userRepository.findUsersByDepartmentId(departmentId);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user->{
            userDtos.add(userMapper.toDto(user));
        });
        return userDtos;

    }

    // get users by manger id
    public List<UserDto> getUsersByManagerId(Long mangerId) {
        List<User> users = userRepository.findUsersByManagerId(mangerId);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user->{
            userDtos.add(userMapper.toDto(user));
        });
        return userDtos;
    }

    // get users by Role
    public List<UserDto> getUsersByRoleId(Long RoleId){
        List<User> users = userRepository.findUsersByRoleId(RoleId);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user->{
            userDtos.add(userMapper.toDto(user));
        });
        return userDtos;
    }

    //get users by  hireDate range
    List<UserDto> getUserByHireDateRange(LocalDateTime startDate,LocalDateTime endDate){
        List<User> users = userRepository.findUsersByHireDateBetween(startDate,endDate);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user->{
            userDtos.add(userMapper.toDto(user));

        });
        return userDtos;
    }

    //

}
