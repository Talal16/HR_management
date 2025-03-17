package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.RoleDto;
import com.hrmanagement.hr_management.models.Role;
import com.hrmanagement.hr_management.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrmanagement.hr_management.mappers.RoleMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;


    // create role
    public RoleDto createRole(RoleDto roleDto) {
        Role role =    roleMapper.toEntity(roleDto);
        return roleMapper.toDto(roleRepository.save(role));
    }

    // get role by id
    public RoleDto getRole(Long id) {
        return roleMapper.toDto(roleRepository.findById(id).orElse(null));
    }


    // update role
    public RoleDto updateRole(RoleDto roleDto) {
        Role role = roleRepository.findById(roleDto.getId()).orElse(null);
        if (role == null ) {
            return null;
        }
        role.setRoleName(roleDto.getRoleName());

        return roleMapper.toDto(roleRepository.save(role));
    }







    // delete role
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }


    // get all roles
    public List<RoleDto> getAllRoles(){

        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtos = new ArrayList<>();
        roles.forEach(role -> {
            roleDtos.add(roleMapper.toDto(role));
        });
        return roleDtos;
    }


}
