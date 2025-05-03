package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.LeaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveApprovalRepository extends JpaRepository<LeaveApproval, Long> {
    List<LeaveApproval> findByEmployeeId(Long employeeId);
    LeaveApproval findByLeaveRequestId(Long leaveRequestId);
    List<LeaveApproval> findByManagerId(Long managerId);
    List<LeaveApproval> findByStatus(String status);
    LeaveApproval findByLeaveRequestIdAndEmployeeId(Long leaveRequestId, Long employeeId);
    LeaveApproval findByLeaveRequestIdAndManagerId(Long leaveRequestId, Long managerId);

}