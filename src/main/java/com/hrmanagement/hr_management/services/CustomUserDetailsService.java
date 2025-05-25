package com.hrmanagement.hr_management.services;


import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.mappers.UserMapper;
import com.hrmanagement.hr_management.models.User;
import com.hrmanagement.hr_management.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService {
    //constructor injection
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto loadUserByUserId(Long userId)throws UsernameNotFoundException {
        User user = userRepository.findById(userId)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDto userDto = userMapper.toDto(user);
                return userDto;
    }

}
