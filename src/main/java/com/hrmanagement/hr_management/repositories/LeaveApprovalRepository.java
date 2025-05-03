package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.LeaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveApprovalRepository extends JpaRepository<LeaveApproval, Long> {

    @Query("SELECT la FROM LeaveApproval la WHERE la.employee.id = :employeeId")
    List<LeaveApproval> findByEmployeeId(@Param("employeeId") Long employeeId);

    @Query("SELECT la FROM LeaveApproval la WHERE la.leaveRequest.id = :leaveRequestId")
    LeaveApproval findByLeaveRequestId(@Param("leaveRequestId") Long leaveRequestId);

    @Query("SELECT la FROM LeaveApproval la WHERE la.manager.id = :managerId")
    List<LeaveApproval> findByManagerId(@Param("managerId") Long managerId);

    @Query("SELECT la FROM LeaveApproval la WHERE la.status = :status")
    List<LeaveApproval> findByStatus(@Param("status") String status);

    @Query("SELECT la FROM LeaveApproval la WHERE la.leaveRequest.id = :leaveRequestId AND la.employee.id = :employeeId")
    LeaveApproval findByLeaveRequestIdAndEmployeeId(@Param("leaveRequestId") Long leaveRequestId, @Param("employeeId") Long employeeId);

    @Query("SELECT la FROM LeaveApproval la WHERE la.leaveRequest.id = :leaveRequestId AND la.manager.id = :managerId")
    LeaveApproval findByLeaveRequestIdAndManagerId(@Param("leaveRequestId") Long leaveRequestId, @Param("managerId") Long managerId);
}