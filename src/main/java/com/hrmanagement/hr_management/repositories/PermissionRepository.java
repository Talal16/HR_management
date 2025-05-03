package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("SELECT p FROM Permission p WHERE p.user.id = :userId")
    List<Permission> findAllByUserId(@Param("userId") Long userId);

    @Query("SELECT p FROM Permission p WHERE p.user.id = :userId AND p.status = :status")
    List<Permission> findAllByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);

    @Query("SELECT p FROM Permission p WHERE p.status = :status")
    List<Permission> findAllByStatus(@Param("status") String status);

    @Query("SELECT p FROM Permission p WHERE p.user.id = :userId AND p.status = :status AND p.startTime BETWEEN :startTime AND :endTime")
    List<Permission> findAllByUserIdAndStatusAndStartTimeBetween(@Param("userId") Long userId, @Param("status") String status, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT p FROM Permission p WHERE p.user.id = :userId AND p.startTime BETWEEN :startTime AND :endTime")
    List<Permission> findAllByUserIdAndStartTimeBetween(@Param("userId") Long userId, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT p FROM Permission p WHERE p.status = :status AND p.startTime BETWEEN :startTime AND :endTime")
    List<Permission> findAllByStatusAndStartTimeBetween(@Param("status") String status, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT p FROM Permission p WHERE p.startTime BETWEEN :startTime AND :endTime")
    List<Permission> findAllByStartTimeBetween(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}