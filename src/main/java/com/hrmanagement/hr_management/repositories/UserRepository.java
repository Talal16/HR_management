package com.hrmanagement.hr_management.repositories;

 import com.hrmanagement.hr_management.models.User;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.query.Param;
 import org.springframework.stereotype.Repository;

 import java.time.LocalDateTime;
 import java.util.List;

 @Repository
 public interface UserRepository extends JpaRepository<User, Long> {


     @Query("SELECT i FROM User u WHERE u.id = :userId")
     User getUserById(@Param("userid") Long userId);

     @Query("SELECT u FROM User u WHERE u.department.id = :departmentId")
     List<User> findUsersByDepartmentId(@Param("departmentId") Long departmentId);

     @Query("SELECT u FROM User u WHERE u.email = :email")
     User findUserByEmail(@Param("email") String email);

     @Query("SELECT u FROM User u WHERE u.manager.id = :managerId")
     List<User> findUsersByManagerId(@Param("managerId") Long managerId);

     @Query("SELECT u FROM User u WHERE u.role.id = :roleId")
     List<User> findUsersByRoleId(@Param("roleId") Long roleId);

     @Query("SELECT u FROM User u WHERE u.hireDate BETWEEN :startDate AND :endDate")
     List<User> findUsersByHireDateBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
 }