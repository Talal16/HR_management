package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById (Long userId);
    List<User> findUsersByDepartmentId(Long departmentId);
    User findUserByEmail (String email);
    List<User> findUsersByManagerId(Long managerId);
    List<User> findUsersByRoleId(Long RoleId);
    List<User> findUsersByHireDateBetween(LocalDateTime startDate, LocalDateTime endDate);
 }