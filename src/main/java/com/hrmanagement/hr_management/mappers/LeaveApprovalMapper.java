package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveApprovalDto;
import com.hrmanagement.hr_management.models.LeaveApproval;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveApprovalMapper {

    LeaveApprovalDto toDto(LeaveApproval leaveApproval);


    LeaveApproval toEntity(LeaveApprovalDto leaveApprovalDto);

}
