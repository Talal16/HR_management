package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveRequestDto;
import com.hrmanagement.hr_management.models.LeaveRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LeaveTypeMapper.class})
public interface LeaveRequestMapper {
    LeaveRequestDto toDto(LeaveRequest leaveRequest);

    LeaveRequest toEntity(LeaveRequestDto leaveRequestDto);
}
