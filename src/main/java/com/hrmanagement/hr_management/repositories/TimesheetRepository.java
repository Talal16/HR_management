package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
    List<Timesheet> findByUserId(Long userId);
    List<Timesheet> findByProjectId(Long projectId);
}
