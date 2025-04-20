package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
  List<Permission> findAllByUserId(Long userId);

    List<Permission> findAllByUserIdAndStatus(Long userId, String status);
    List<Permission> findAllByStatus(String status);
    List<Permission> findAllByUserIdAndStatusAndStartTimeBetween(Long userId, String status, String startTime, String endTime);
    List<Permission> findAllByUserIdAndStartTimeBetween(Long userId, String startTime, String endTime);
    List<Permission> findAllByStatusAndStartTimeBetween(String status, String startTime, String endTime);
    List<Permission> findAllByStartTimeBetween(String startTime, String endTime);
}