package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveTypeDto;
import com.hrmanagement.hr_management.dto.UserDto;
import com.hrmanagement.hr_management.models.LeaveType;
import com.hrmanagement.hr_management.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveTypeMapper {

    LeaveTypeDto toDto(LeaveType leaveTypeEntity);

    LeaveType toEntity(LeaveTypeDto leaveTypeDto);


}
