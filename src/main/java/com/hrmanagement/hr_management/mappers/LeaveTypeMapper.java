package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveTypeDto;
import com.hrmanagement.hr_management.models.LeaveType;
import org.mapstruct.Mapper;

@Mapper
public interface LeaveTypeMapper {

    LeaveTypeDto map(LeaveType leaveTypeEntity);

    LeaveType unmap(LeaveTypeDto leaveTypeDto);
}
