package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveTypeDto;
import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.LeaveType;
import com.hrmanagement.hr_management.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface LeaveTypeMapper {

    LeaveTypeDto map(LeaveType leaveTypeEntity);

    LeaveType unmap(LeaveTypeDto leaveTypeDto);

    @Mapper
    interface UserMapper {

        UserDto toEntity(User userEntity);
        User unmap(UserDto userDto) ;
    }
}
