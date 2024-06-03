package com.java.ems.mapper;

import com.java.ems.dto.DepartmentDto;
import com.java.ems.entity.Department;

public class DepartmentMapper {
	public static DepartmentDto mapToDepartmentDto(Department department) {
		return new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription()
				
				);
		
	}
	
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription()
				
				);
		
	}

}
