package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByDepartmentId(Long departmentId);
}