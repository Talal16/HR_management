package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveApprovalDto;
import com.hrmanagement.hr_management.models.LeaveApproval;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-23T09:49:35+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LeaveApprovalMapperImpl implements LeaveApprovalMapper {

    @Override
    public LeaveApprovalDto toDto(LeaveApproval leaveApproval) {
        if ( leaveApproval == null ) {
            return null;
        }

        LeaveApprovalDto leaveAprovalDto = new LeaveApprovalDto();

        return leaveAprovalDto;
    }

    @Override
    public LeaveApproval toEntity(LeaveApprovalDto leaveApprovalDto) {
        if ( leaveApprovalDto == null ) {
            return null;
        }

        LeaveApproval leaveApproval = new LeaveApproval();

        return leaveApproval;
    }
}
