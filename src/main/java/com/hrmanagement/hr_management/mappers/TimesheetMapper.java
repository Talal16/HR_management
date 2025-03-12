package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.TimesheetDto;
import com.hrmanagement.hr_management.models.Timesheet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimesheetMapper {

    TimesheetDto toDto(Timesheet timesheet);

    Timesheet toEntity(TimesheetDto timesheetDto);
 }
