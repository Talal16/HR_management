package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.LeaveTypeDto;
import com.hrmanagement.hr_management.mappers.LeaveTypeMapper;
import com.hrmanagement.hr_management.models.LeaveType;
import com.hrmanagement.hr_management.repositories.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveTypeService {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;
    @Autowired
    private LeaveTypeMapper leaveTypeMapper;

    //create new LeaveType
    public LeaveTypeDto createLeaveType(LeaveTypeDto leaveTypeDto) {
        LeaveType leaveType = leaveTypeMapper.toEntity(leaveTypeDto);

        leaveTypeRepository.save(leaveType);
        return leaveTypeMapper.toDto(leaveType);
    }
    //get LeaveType by id
    public LeaveTypeDto getLeaveType(Long id) {
        LeaveType leaveType = leaveTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveType not found"));
        return leaveTypeMapper.toDto(leaveType);
    }

    //update
    public LeaveTypeDto updateLeaveType(Long id, LeaveTypeDto leaveTypeDto) {
        LeaveType leaveType = leaveTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveType not found"));
        leaveType.setName(leaveTypeDto.getName());
        leaveType.setDefaultDays(leaveTypeDto.getDefaultDays());
        return leaveTypeMapper.toDto(leaveTypeRepository.save(leaveType));
    }

    // delete
    public  void deleteLeaveType(Long id) {
        leaveTypeRepository.deleteById(id);
    }

    //get all leaveTypes
    public List<LeaveTypeDto> getAllLeaveTypes() {
        List<LeaveType> leaveTypes =  leaveTypeRepository.findAll();
        List <LeaveTypeDto> leaveTypeDtos = new ArrayList<>();
        leaveTypes.forEach(leaveType -> leaveTypeDtos.add(leaveTypeMapper.toDto(leaveType)));
        return leaveTypeDtos;
    }
}

