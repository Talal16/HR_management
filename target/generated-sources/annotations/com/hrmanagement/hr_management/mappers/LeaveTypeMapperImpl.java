package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.LeaveTypeDto;
import com.hrmanagement.hr_management.models.LeaveType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T09:56:17+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LeaveTypeMapperImpl implements LeaveTypeMapper {

    @Override
    public LeaveTypeDto toDto(LeaveType leaveTypeEntity) {
        if ( leaveTypeEntity == null ) {
            return null;
        }

        LeaveTypeDto leaveTypeDto = new LeaveTypeDto();

        leaveTypeDto.setId( leaveTypeEntity.getId() );
        leaveTypeDto.setName( leaveTypeEntity.getName() );
        leaveTypeDto.setDefaultDays( leaveTypeEntity.getDefaultDays() );

        return leaveTypeDto;
    }

    @Override
    public LeaveType toEntity(LeaveTypeDto leaveTypeDto) {
        if ( leaveTypeDto == null ) {
            return null;
        }

        LeaveType leaveType = new LeaveType();

        leaveType.setId( leaveTypeDto.getId() );
        leaveType.setName( leaveTypeDto.getName() );
        leaveType.setDefaultDays( leaveTypeDto.getDefaultDays() );

        return leaveType;
    }
}
