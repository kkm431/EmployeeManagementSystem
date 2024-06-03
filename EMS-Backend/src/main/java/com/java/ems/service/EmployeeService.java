package com.java.ems.service;

import java.util.List;

import com.java.ems.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getemployeebyId(Long employeeId);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	
	void deleteEmployee(Long employeeId);
}
