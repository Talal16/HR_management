package com.hrmanagement.hr_management.services.user;

import lombok.RequiredArgsConstructor;
import com.hrmanagement.hr_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hrmanagement.hr_management.models.User;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService implements UserServiceIn     {
    //@Autowired
    //private  UserRepository userRepository;
    //private  PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        try{
            System.out.println("User found");
        }
        catch (Exception e){
            System.out.println("User not found. error:"+e.getMessage());
        }
        // spacial exceptions
        return null;
    }

    @Override
    public User createUser(User requestUser) {
        try{

            //requestUser.setPassword(passwordEncoder.encode(requestUser.getPassword())); // change to hash
            System.out.println("User created");
           // return userRepository.save(requestUser);
        }
        catch (Exception e){
            System.out.println("User not created. error:"+e.getMessage());
        }

        return null;
    }

    @Override
    public User updateUser(Long id, User requestUser) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }



    @Override
    public void deleteUser(Long id) {


    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
