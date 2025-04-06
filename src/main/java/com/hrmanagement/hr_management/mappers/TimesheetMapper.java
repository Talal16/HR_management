package com.hrmanagement.hr_management.mappers;

import com.hrmanagement.hr_management.dto.TimesheetDto;
import com.hrmanagement.hr_management.models.Timesheet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface TimesheetMapper {
    public TimesheetDto toDto (Timesheet timesheetEntity);
    public Timesheet toEntity (TimesheetDto timesheetDto);

 }
