package com.hrmanagement.hr_management.repositories;

 import com.hrmanagement.hr_management.models.LeaveRequest;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;

 import java.time.LocalDateTime;
 import java.util.List;

 public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.employee.id = :employeeId")
     List<LeaveRequest> findByEmployeeId(@Param("employeeId") Long employeeId);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.status = :status")
     List<LeaveRequest> findByStatus(@Param("status") String status);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.leaveType.id = :leaveTypeId")
     List<LeaveRequest> findByLeaveTypeId(@Param("leaveTypeId") Long leaveTypeId);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.employee.id = :employeeId AND lr.status = :status")
     List<LeaveRequest> findByEmployeeIdAndStatus(@Param("employeeId") Long employeeId, @Param("status") String status);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.employee.id = :employeeId AND lr.leaveType.id = :leaveTypeId")
     List<LeaveRequest> findByEmployeeIdAndLeaveTypeId(@Param("employeeId") Long employeeId, @Param("leaveTypeId") Long leaveTypeId);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.employee.id = :employeeId AND lr.leaveType.id = :leaveTypeId AND lr.status = :status")
     List<LeaveRequest> findByEmployeeIdAndLeaveTypeIdAndStatus(@Param("employeeId") Long employeeId, @Param("leaveTypeId") Long leaveTypeId, @Param("status") String status);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.leaveType.id = :leaveTypeId AND lr.status = :status")
     List<LeaveRequest> findByLeaveTypeIdAndStatus(@Param("leaveTypeId") Long leaveTypeId, @Param("status") String status);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.leaveType.id = :leaveTypeId AND lr.employee.id = :employeeId AND lr.status = :status")
     List<LeaveRequest> findByLeaveTypeIdAndEmployeeIdAndStatus(@Param("leaveTypeId") Long leaveTypeId, @Param("employeeId") Long employeeId, @Param("status") String status);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.startDate = :startDate")
     List<LeaveRequest> findByStartDate(@Param("startDate") LocalDateTime startDate);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.endDate = :endDate")
     List<LeaveRequest> findByEndDate(@Param("endDate") LocalDateTime endDate);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.createdAt = :createdAt")
     List<LeaveRequest> findByCreatedAt(@Param("createdAt") LocalDateTime createdAt);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.employee.id = :employeeId AND lr.startDate = :startDate")
     List<LeaveRequest> findByEmployeeIdAndStartDate(@Param("employeeId") Long employeeId, @Param("startDate") LocalDateTime startDate);
 }