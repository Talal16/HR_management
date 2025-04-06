package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.LeaveRequestDto;
import com.hrmanagement.hr_management.mappers.LeaveRequestMapper;
import com.hrmanagement.hr_management.mappers.LeaveTypeMapper;
import com.hrmanagement.hr_management.models.LeaveRequest;
import com.hrmanagement.hr_management.models.LeaveType;
import com.hrmanagement.hr_management.repositories.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveRequestService {
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private LeaveRequestMapper leaveRequestMapper;
    @Autowired
    private LeaveTypeMapper leaveTypeMapper;



    // create a new LeaveRequest
    public LeaveRequestDto createLeaveRequest(LeaveRequestDto leaveRequestDto) {
        LeaveRequest leaveRequest = leaveRequestMapper.toEntity(leaveRequestDto);
        leaveRequest.setCreatedAt(LocalDateTime.now());
        leaveRequest.setUpdatedAt(LocalDateTime.now());

        return leaveRequestMapper.toDto(leaveRequestRepository.save(leaveRequest));
    }

    // get LeaveRequest by id
    public LeaveRequestDto getLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveRequest not found"));

        return leaveRequestMapper.toDto(leaveRequest);
    }

    //update LeaveRequest
    public LeaveRequestDto updateLeaveRequest(Long id, LeaveRequestDto leaveRequestDto) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveRequest not found"));
        leaveRequest.setStartDate(leaveRequestDto.getStartDate());
        leaveRequest.setEndDate(leaveRequestDto.getEndDate());
        leaveRequest.setLeaveType(leaveTypeMapper.toEntity( leaveRequestDto.getLeaveType()));
        leaveRequest.setUpdatedAt(LocalDateTime.now());

        return leaveRequestMapper.toDto(leaveRequestRepository.save(leaveRequest));
    }

    //delete LeaveRequest

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }

    // get all LeaveRequests
    public List<LeaveRequestDto> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findAll();
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }

}
