package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.DepartmentDto;
import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.mappers.DepartmentMapper;
import com.hrmanagement.hr_management.mappers.UserMapper;
import com.hrmanagement.hr_management.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.hrmanagement.hr_management.repositories.DepartmentRepository;
import com.hrmanagement.hr_management.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;


    // get all departments
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        departments.forEach(department -> {
            departmentDtos.add(departmentMapper.toDto(department));
        });

        return departmentDtos;
    }



    // create a department
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        System.out.println("CREATE DEPARTMENT DTO :____________"+departmentDto);

        Department department = departmentMapper.toEntity(departmentDto);
        System.out.println("CREATE DEPARTMENT entitiy :____________"+ department);

        return departmentMapper.toDto(departmentRepository.save(department));
    }


    // get a department by id

    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return departmentMapper.toDto(department);}


    // update department

    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        department.setManager(departmentDto.getManager());
        return departmentMapper.toDto(departmentRepository.save(department));

    }

    // delete department
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepository.delete(department);
    }



}
