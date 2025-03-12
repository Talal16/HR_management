package com.hrmanagement.hr_management.service.user;
import com.hrmanagement.hr_management.models.User;

import java.util.List;

public interface UserServiceIn {
    User createUser(User requestUser);
    User updateUser(Long id, User requestUser);  //why optional?
    User getUserByEmail(String email);
    User getUserById(Long id);
    void deleteUser(Long id);
    List <User> getAllUsers();



}
