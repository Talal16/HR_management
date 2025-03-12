package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
  }