package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectByUserId(Long userId);

}