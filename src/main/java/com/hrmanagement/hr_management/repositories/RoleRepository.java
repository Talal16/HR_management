package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

