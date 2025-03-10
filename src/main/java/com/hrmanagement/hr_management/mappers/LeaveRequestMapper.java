package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveRequestDto;
import com.hrmanagement.hr_management.models.LeaveRequest;
import org.mapstruct.Mapper;

@Mapper
public interface LeaveRequestMapper {
    LeaveRequestDto map(LeaveRequest leaveRequest);

    LeaveRequest unmap(LeaveRequestDto leaveRequestDto);
}
