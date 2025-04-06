package com.hrmanagement.hr_management.services;

import com.hrmanagement.hr_management.mappers.LeaveApprovalMapper;
import com.hrmanagement.hr_management.mappers.LeaveRequestMapper;
import com.hrmanagement.hr_management.models.LeaveApproval;
import com.hrmanagement.hr_management.dto.LeaveApprovalDto;
import com.hrmanagement.hr_management.repositories.LeaveApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveApprovalService {
    @Autowired
    private LeaveApprovalRepository leaveApprovalRepository;
    @Autowired
    private LeaveApprovalMapper leaveApprovalMapper;
    @Autowired
    private LeaveRequestMapper leaveRequestMapper;

    //Create LeaveApproval
    public LeaveApprovalDto createLeaveApproval(LeaveApprovalDto leaveApprovalDto) {
        LeaveApproval leaveApproval = leaveApprovalMapper.toEntity(leaveApprovalDto);
        return leaveApprovalMapper.toDto(leaveApprovalRepository.save(leaveApproval));
    }

    //Get LeaveApproval by Id
    public LeaveApprovalDto getLeaveApproval(Long id) {
        return leaveApprovalMapper.toDto(leaveApprovalRepository.findById(id).get());
    }

    //Update LeaveApproval
    public LeaveApprovalDto updateLeaveApproval(Long id, LeaveApprovalDto leaveApprovalDto) {
        LeaveApproval leaveApproval = leaveApprovalMapper.toEntity(leaveApprovalDto);
        leaveApproval.setLeaveRequest(leaveRequestMapper.toEntity(leaveApprovalDto.getLeaveRequest()));
        return leaveApprovalMapper.toDto(leaveApprovalRepository.save(leaveApproval));
    }

    //Delete LeaveApproval
    public void deleteLeaveApproval(Long id) {
        leaveApprovalRepository.deleteById(id);
    }

    //Get all LeaveApprovals
    public List<LeaveApprovalDto> getAllLeaveApprovals() {
        List<LeaveApproval> leaveApprovals = leaveApprovalRepository.findAll();
        List<LeaveApprovalDto> leaveApprovalDtos = new ArrayList<>();
        leaveApprovals.forEach(
                leaveApproval -> leaveApprovalDtos.add(leaveApprovalMapper.toDto(leaveApproval))
        );
        return leaveApprovalDtos;
    }


}
