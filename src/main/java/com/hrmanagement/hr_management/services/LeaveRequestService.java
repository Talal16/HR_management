package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.dto.LeaveRequestDto;
import com.hrmanagement.hr_management.mappers.LeaveRequestMapper;
import com.hrmanagement.hr_management.mappers.LeaveTypeMapper;
import com.hrmanagement.hr_management.models.LeaveRequest;
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

    // get all LeaveRequests by employee id
    public List<LeaveRequestDto> getAllLeaveRequestsByEmployeeId(Long employeeId) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEmployeeId(employeeId);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
    // get all LeaveRequests by leaveType id
    public List<LeaveRequestDto> getAllLeaveRequestsByLeaveTypeId(Long leaveTypeId) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByLeaveTypeId(leaveTypeId);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
    // get all LeaveRequests by status
    public List<LeaveRequestDto> getAllLeaveRequestsByStatus(String status) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByStatus(status);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
    // get all LeaveRequests by start date
    public List<LeaveRequestDto> getAllLeaveRequestsByStartDate(LocalDateTime startDate) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByStartDate(startDate);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
    // get all LeaveRequests by end date
    public List<LeaveRequestDto> getAllLeaveRequestsByEndDate(LocalDateTime endDate) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEndDate(endDate);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
    // get all LeaveRequests by created date
    public List<LeaveRequestDto> getAllLeaveRequestsByCreatedDate(LocalDateTime createdDate) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByCreatedAt(createdDate);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
    // get leaveRequests by User id and leaveType id
    public List<LeaveRequestDto> getAllLeaveRequestsByUserIdAndLeaveTypeId(Long employeeId, Long leaveTypeId) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEmployeeIdAndLeaveTypeId(employeeId, leaveTypeId);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }

    // get leaveRequest by employee id and status
    public List<LeaveRequestDto> getAllLeaveRequestsByUserIdAndStatus(Long employeeId, String status) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEmployeeIdAndStatus(employeeId, status);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
    // get leaveRequest by employee id and start date
    public List<LeaveRequestDto> getAllLeaveRequestsByUserIdAndStartDate(Long employeeId, LocalDateTime startDate) {
        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEmployeeIdAndStartDate(employeeId, startDate);
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        leaveRequests.forEach(leaveRequest -> leaveRequestDtos.add(leaveRequestMapper.toDto(leaveRequest)));

        return leaveRequestDtos;
    }
/*
    //rejectLeaveRequest
    public LeaveRequestDto rejectLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveRequest not found"));
        leaveRequest.setStatus("rejected");
        leaveRequest.setUpdatedAt(LocalDateTime.now());

        return leaveRequestMapper.toDto(leaveRequestRepository.save(leaveRequest));
    }

    public LeaveRequestDto approveLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveRequest not found"));
        leaveRequest.setStatus("approved");
        leaveRequest.setUpdatedAt(LocalDateTime.now());

        return leaveRequestMapper.toDto(leaveRequestRepository.save(leaveRequest));
    }
*/
}
