package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

}
