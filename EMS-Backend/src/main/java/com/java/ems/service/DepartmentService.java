package com.java.ems.service;

import java.util.List;

import com.java.ems.dto.DepartmentDto;


public interface DepartmentService {
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentById(Long departmentId);
	
	List<DepartmentDto> getAllDepartments();

	DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);

	void deleteDepartment(Long departmentId);

}
