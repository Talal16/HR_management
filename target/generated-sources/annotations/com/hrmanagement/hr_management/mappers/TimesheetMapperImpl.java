package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.ProjectDto;
import com.hrmanagement.hr_management.dto.RoleDto;
import com.hrmanagement.hr_management.dto.TimesheetDto;
import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.Project;
import com.hrmanagement.hr_management.models.Role;
import com.hrmanagement.hr_management.models.Timesheet;
import com.hrmanagement.hr_management.models.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-23T09:49:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class TimesheetMapperImpl implements TimesheetMapper {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public TimesheetDto toDto(Timesheet timesheet) {
        if ( timesheet == null ) {
            return null;
        }

        TimesheetDto timesheetDto = new TimesheetDto();

        timesheetDto.setId( timesheet.getId() );
        timesheetDto.setUser( userToUserDto( timesheet.getUser() ) );
        timesheetDto.setProject( projectToProjectDto( timesheet.getProject() ) );
        timesheetDto.setCreatedAt( timesheet.getCreatedAt() );
        timesheetDto.setUpdatedAt( timesheet.getUpdatedAt() );

        return timesheetDto;
    }

    @Override
    public Timesheet toEntity(TimesheetDto timesheetDto) {
        if ( timesheetDto == null ) {
            return null;
        }

        Timesheet timesheet = new Timesheet();

        timesheet.setId( timesheetDto.getId() );
        timesheet.setUser( userDtoToUser( timesheetDto.getUser() ) );
        timesheet.setProject( projectDtoToProject( timesheetDto.getProject() ) );
        timesheet.setCreatedAt( timesheetDto.getCreatedAt() );
        timesheet.setUpdatedAt( timesheetDto.getUpdatedAt() );

        return timesheet;
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

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setRole( roleToRoleDto( user.getRole() ) );
        userDto.setDepartment( departmentMapper.toDto( user.getDepartment() ) );
        userDto.setManager( userToUserDto( user.getManager() ) );
        userDto.setHireDate( user.getHireDate() );
        userDto.setCreatedAt( user.getCreatedAt() );
        userDto.setUpdatedAt( user.getUpdatedAt() );

        return userDto;
    }

    protected ProjectDto projectToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( project.getId() );
        projectDto.setName( project.getName() );
        projectDto.setDescription( project.getDescription() );

        return projectDto;
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

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setEmail( userDto.getEmail() );
        user.setName( userDto.getName() );
        user.setPassword( userDto.getPassword() );
        user.setRole( roleDtoToRole( userDto.getRole() ) );
        user.setDepartment( departmentMapper.toEntity( userDto.getDepartment() ) );
        user.setManager( userDtoToUser( userDto.getManager() ) );
        user.setHireDate( userDto.getHireDate() );
        user.setCreatedAt( userDto.getCreatedAt() );
        user.setUpdatedAt( userDto.getUpdatedAt() );

        return user;
    }

    protected Project projectDtoToProject(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDto.getId() );
        project.setName( projectDto.getName() );
        project.setDescription( projectDto.getDescription() );

        return project;
    }
}
