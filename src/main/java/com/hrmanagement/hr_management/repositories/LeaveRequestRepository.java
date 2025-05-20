package com.hrmanagement.hr_management.repositories;

 import com.hrmanagement.hr_management.models.LeaveRequest;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;

 import java.time.LocalDateTime;
 import java.util.List;

 public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.user.id = :userId")
     List<LeaveRequest> findByuserId(@Param("userId") Long userId);


     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.leaveType.id = :leaveTypeId")
     List<LeaveRequest> findByLeaveTypeId(@Param("leaveTypeId") Long leaveTypeId);


     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.user.id = :userId AND lr.leaveType.id = :leaveTypeId")
     List<LeaveRequest> findByuserIdAndLeaveTypeId(@Param("userId") Long userId, @Param("leaveTypeId") Long leaveTypeId);



     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.startDate = :startDate")
     List<LeaveRequest> findByStartDate(@Param("startDate") LocalDateTime startDate);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.endDate = :endDate")
     List<LeaveRequest> findByEndDate(@Param("endDate") LocalDateTime endDate);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.createdAt = :createdAt")
     List<LeaveRequest> findByCreatedAt(@Param("createdAt") LocalDateTime createdAt);

     @Query("SELECT lr FROM LeaveRequest lr WHERE lr.user.id = :userId AND lr.startDate = :startDate")
     List<LeaveRequest> findByuserIdAndStartDate(@Param("userId") Long userId, @Param("startDate") LocalDateTime startDate);
 }