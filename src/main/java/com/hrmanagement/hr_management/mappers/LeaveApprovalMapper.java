package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveAprovalDto;
import com.hrmanagement.hr_management.models.LeaveApproval;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaveApprovalMapper {

    LeaveAprovalDto toDto(LeaveApproval leaveApproval);


    LeaveApproval toEntity(LeaveAprovalDto leaveApprovalDto);

}
