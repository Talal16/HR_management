package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
    Optional<LeaveType> findByName(String name);
}