package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveAprovalDto;
import com.hrmanagement.hr_management.models.LeaveApproval;
import org.mapstruct.Mapper;

@Mapper
public interface LeaveApprovalMapper {

    LeaveAprovalDto map(LeaveApproval leaveApproval);


    LeaveApproval unmap(LeaveAprovalDto leaveApprovalDto);

}
