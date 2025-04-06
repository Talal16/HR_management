package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.DepartmentDto;
import com.hrmanagement.hr_management.dto.LeaveApprovalDto;
import com.hrmanagement.hr_management.dto.LeaveRequestDto;
import com.hrmanagement.hr_management.dto.LeaveTypeDto;
import com.hrmanagement.hr_management.dto.RoleDto;
import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.Department;
import com.hrmanagement.hr_management.models.LeaveApproval;
import com.hrmanagement.hr_management.models.LeaveRequest;
import com.hrmanagement.hr_management.models.LeaveType;
import com.hrmanagement.hr_management.models.Role;
import com.hrmanagement.hr_management.models.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T10:31:30+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LeaveApprovalMapperImpl implements LeaveApprovalMapper {

    @Override
    public LeaveApprovalDto toDto(LeaveApproval leaveApproval) {
        if ( leaveApproval == null ) {
            return null;
        }

        LeaveApprovalDto leaveApprovalDto = new LeaveApprovalDto();

        leaveApprovalDto.setId( leaveApproval.getId() );
        leaveApprovalDto.setLeaveRequest( leaveRequestToLeaveRequestDto( leaveApproval.getLeaveRequest() ) );
        leaveApprovalDto.setApprovedBy( userToUserDto( leaveApproval.getApprovedBy() ) );
        leaveApprovalDto.setStatus( leaveApproval.getStatus() );
        leaveApprovalDto.setCreateAt( leaveApproval.getCreateAt() );
        leaveApprovalDto.setApprovedAt( leaveApproval.getApprovedAt() );

        return leaveApprovalDto;
    }

    @Override
    public LeaveApproval toEntity(LeaveApprovalDto leaveApprovalDto) {
        if ( leaveApprovalDto == null ) {
            return null;
        }

        LeaveApproval leaveApproval = new LeaveApproval();

        leaveApproval.setId( leaveApprovalDto.getId() );
        leaveApproval.setLeaveRequest( leaveRequestDtoToLeaveRequest( leaveApprovalDto.getLeaveRequest() ) );
        leaveApproval.setApprovedBy( userDtoToUser( leaveApprovalDto.getApprovedBy() ) );
        leaveApproval.setStatus( leaveApprovalDto.getStatus() );
        leaveApproval.setCreateAt( leaveApprovalDto.getCreateAt() );
        leaveApproval.setApprovedAt( leaveApprovalDto.getApprovedAt() );

        return leaveApproval;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setRoleName( role.getRoleName() );

        return roleDto;
    }

    protected DepartmentDto departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( department.getId() );
        departmentDto.setName( department.getName() );
        departmentDto.setDescription( department.getDescription() );
        departmentDto.setManager( department.getManager() );

        return departmentDto;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setRole( roleToRoleDto( user.getRole() ) );
        userDto.setDepartment( departmentToDepartmentDto( user.getDepartment() ) );
        userDto.setManager( userToUserDto( user.getManager() ) );
        userDto.setHireDate( user.getHireDate() );
        userDto.setCreatedAt( user.getCreatedAt() );
        userDto.setUpdatedAt( user.getUpdatedAt() );

        return userDto;
    }

    protected LeaveTypeDto leaveTypeToLeaveTypeDto(LeaveType leaveType) {
        if ( leaveType == null ) {
            return null;
        }

        LeaveTypeDto leaveTypeDto = new LeaveTypeDto();

        leaveTypeDto.setId( leaveType.getId() );
        leaveTypeDto.setName( leaveType.getName() );
        leaveTypeDto.setDefaultDays( leaveType.getDefaultDays() );

        return leaveTypeDto;
    }

    protected LeaveRequestDto leaveRequestToLeaveRequestDto(LeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }

        LeaveRequestDto leaveRequestDto = new LeaveRequestDto();

        leaveRequestDto.setId( leaveRequest.getId() );
        leaveRequestDto.setUser( userToUserDto( leaveRequest.getUser() ) );
        leaveRequestDto.setLeaveType( leaveTypeToLeaveTypeDto( leaveRequest.getLeaveType() ) );
        leaveRequestDto.setStartDate( leaveRequest.getStartDate() );
        leaveRequestDto.setEndDate( leaveRequest.getEndDate() );
        leaveRequestDto.setCreatedAt( leaveRequest.getCreatedAt() );
        leaveRequestDto.setUpdatedAt( leaveRequest.getUpdatedAt() );

        return leaveRequestDto;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setRoleName( roleDto.getRoleName() );

        return role;
    }

    protected Department departmentDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( departmentDto.getId() );
        department.setName( departmentDto.getName() );
        department.setDescription( departmentDto.getDescription() );
        department.setManager( departmentDto.getManager() );

        return department;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setEmail( userDto.getEmail() );
        user.setName( userDto.getName() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setPassword( userDto.getPassword() );
        user.setRole( roleDtoToRole( userDto.getRole() ) );
        user.setDepartment( departmentDtoToDepartment( userDto.getDepartment() ) );
        user.setManager( userDtoToUser( userDto.getManager() ) );
        user.setHireDate( userDto.getHireDate() );
        user.setCreatedAt( userDto.getCreatedAt() );
        user.setUpdatedAt( userDto.getUpdatedAt() );

        return user;
    }

    protected LeaveType leaveTypeDtoToLeaveType(LeaveTypeDto leaveTypeDto) {
        if ( leaveTypeDto == null ) {
            return null;
        }

        LeaveType leaveType = new LeaveType();

        leaveType.setId( leaveTypeDto.getId() );
        leaveType.setName( leaveTypeDto.getName() );
        leaveType.setDefaultDays( leaveTypeDto.getDefaultDays() );

        return leaveType;
    }

    protected LeaveRequest leaveRequestDtoToLeaveRequest(LeaveRequestDto leaveRequestDto) {
        if ( leaveRequestDto == null ) {
            return null;
        }

        LeaveRequest leaveRequest = new LeaveRequest();

        leaveRequest.setId( leaveRequestDto.getId() );
        leaveRequest.setUser( userDtoToUser( leaveRequestDto.getUser() ) );
        leaveRequest.setLeaveType( leaveTypeDtoToLeaveType( leaveRequestDto.getLeaveType() ) );
        leaveRequest.setStartDate( leaveRequestDto.getStartDate() );
        leaveRequest.setEndDate( leaveRequestDto.getEndDate() );
        leaveRequest.setCreatedAt( leaveRequestDto.getCreatedAt() );
        leaveRequest.setUpdatedAt( leaveRequestDto.getUpdatedAt() );

        return leaveRequest;
    }
}
