package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveRequestDto;
import com.hrmanagement.hr_management.models.LeaveRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-23T09:49:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LeaveRequestMapperImpl implements LeaveRequestMapper {

    @Override
    public LeaveRequestDto toDto(LeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }

        LeaveRequestDto leaveRequestDto = new LeaveRequestDto();

        return leaveRequestDto;
    }

    @Override
    public LeaveRequest toEntity(LeaveRequestDto leaveRequestDto) {
        if ( leaveRequestDto == null ) {
            return null;
        }

        LeaveRequest leaveRequest = new LeaveRequest();

        return leaveRequest;
    }
}
