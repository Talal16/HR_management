package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveAprovalDto;
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
    public LeaveAprovalDto toDto(LeaveApproval leaveApproval) {
        if ( leaveApproval == null ) {
            return null;
        }

        LeaveAprovalDto leaveAprovalDto = new LeaveAprovalDto();

        return leaveAprovalDto;
    }

    @Override
    public LeaveApproval toEntity(LeaveAprovalDto leaveApprovalDto) {
        if ( leaveApprovalDto == null ) {
            return null;
        }

        LeaveApproval leaveApproval = new LeaveApproval();

        return leaveApproval;
    }
}
