package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployeeId(Long employeeId);
    List<LeaveRequest> findByStatus(String status);
    List<LeaveRequest> findByLeaveTypeId(Long leaveTypeId);
    List<LeaveRequest> findByEmployeeIdAndStatus(Long employeeId, String status);
    List<LeaveRequest> findByEmployeeIdAndLeaveTypeId(Long employeeId, Long leaveTypeId);
    List<LeaveRequest> findByEmployeeIdAndLeaveTypeIdAndStatus(Long employeeId, Long leaveTypeId, String status);
    List<LeaveRequest> findByLeaveTypeIdAndStatus(Long leaveTypeId, String status);
    List<LeaveRequest> findByLeaveTypeIdAndEmployeeIdAndStatus(Long leaveTypeId, Long employeeId, String status);
    List<LeaveRequest> findByStartDate(LocalDateTime startDate);
    List<LeaveRequest> findByEndDate(LocalDateTime endDate);
    List<LeaveRequest> findByCreatedAt(LocalDateTime createdAt);
    List<LeaveRequest> findByEmployeeIdAndStartDate(Long employeeId, LocalDateTime startDate);

}