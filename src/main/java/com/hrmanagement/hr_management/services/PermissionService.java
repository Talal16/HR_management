package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.PermissionDto;
import com.hrmanagement.hr_management.mappers.PermissionMapper;
import com.hrmanagement.hr_management.mappers.UserMapper;
import com.hrmanagement.hr_management.models.Permission;
import com.hrmanagement.hr_management.repositories.PermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserMapper userMapper;

    // create new permission
    public PermissionDto createPermission(PermissionDto permissionDto) {
        Permission permission = permissionMapper.toEntity(permissionDto);
        permission.setCreatedAt(LocalDateTime.now());
        permission.setUpdatedAt(LocalDateTime.now());
        
        return   permissionMapper.toDto(permissionRepository.save(permission));
    }

    //update permission
    public PermissionDto updatePermission(Long id, PermissionDto permissionDto) {
        Permission permission = permissionRepository.findById(id).get();
        permission.setUser(userMapper.toEntity(permissionDto.getUser()));
        permission.setStartTime(permissionDto.getStartTime());
        permission.setEndTime(permissionDto.getEndTime());
        permission.setStatus(permission.getStatus());
        permission.setUpdatedAt(LocalDateTime.now());

        return permissionMapper.toDto(permissionRepository.save(permission));
    }

    //get permission by id
    public PermissionDto getPermission(Long id) {
        return permissionMapper.toDto(permissionRepository.findById(id).get());
    }

    // delete permission
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }

    // get all permissions
    public List<PermissionDto> getALlPermissions(){
        List<Permission> permissions = permissionRepository.findAll();
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }
    //-----------------------------------------------------------------
    // get all permissions by user id
    public List<PermissionDto> getAllPermissionsByUserId(Long userId) {
        List<Permission> permissions = permissionRepository.findAllByUserId(userId);
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }

    // get all permissions by status
    public List<PermissionDto> getAllPermissionsByStatus(String status) {
        List<Permission> permissions = permissionRepository.findAllByStatus(status);
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }
    // get all permissions by user id and status
    public List<PermissionDto> getAllPermissionsByUserIdAndStatus(Long userId, String status) {
        List<Permission> permissions = permissionRepository.findAllByUserIdAndStatus(userId, status);
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }
    // get all permissions by user id and status and start time between
    public List<PermissionDto> getAllPermissionsByUserIdAndStatusAndStartTimeBetween(Long userId, String status, String startTime, String endTime) {
        List<Permission> permissions = permissionRepository.findAllByUserIdAndStatusAndStartTimeBetween(userId, status, startTime, endTime);
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }
    // get all permissions by user id and start time between
    public List<PermissionDto> getAllPermissionsByUserIdAndStartTimeBetween(Long userId, String startTime, String endTime) {
        List<Permission> permissions = permissionRepository.findAllByUserIdAndStartTimeBetween(userId, startTime, endTime);
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }
    // get all permissions by status and start time between
    public List<PermissionDto> getAllPermissionsByStatusAndStartTimeBetween(String status, String startTime, String endTime) {
        List<Permission> permissions = permissionRepository.findAllByStatusAndStartTimeBetween(status, startTime, endTime);
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }
    // get all permissions by start time between
    public List<PermissionDto> getAllPermissionsByStartTimeBetween(String startTime, String endTime) {
        List<Permission> permissions = permissionRepository.findAllByStartTimeBetween(startTime, endTime);
        List<PermissionDto> permissionDtos = new ArrayList<>();
        permissions.forEach(permission -> {
            System.out.println("start get all"+permission+"end");
            permissionDtos.add(permissionMapper.toDto(permission));
        });
        return permissionDtos;
    }



}
