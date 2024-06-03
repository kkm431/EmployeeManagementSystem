package com.java.ems.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.ems.dto.EmployeeDto;
import com.java.ems.entity.Employee;
import com.java.ems.exception.ResourceNotFoundException;
import com.java.ems.mapper.EmployeeMapper;
import com.java.ems.repository.EmployeeRepository;
import com.java.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		EmployeeMapper employeeMapper= new EmployeeMapper();
		Employee employee= employeeMapper.mapToEmployee(employeeDto);
		
		Employee EmployeeSaved = employeeRepository.save(employee);
		
		return employeeMapper.mapToEmployeeDto(EmployeeSaved);
	}

	@Override
	public EmployeeDto getemployeebyId(Long employeeId) {
		// TODO Auto-generated method stub
		EmployeeMapper employeeMapper= new EmployeeMapper();
		Employee employeeById = employeeRepository.findById(employeeId).
		orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't exist for given Id:" + employeeId));
		return employeeMapper.mapToEmployeeDto(employeeById); 
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		
		List<Employee> allEmployee = employeeRepository.findAll();
		EmployeeMapper employeeMapper= new EmployeeMapper();
		return allEmployee.stream().map((employee) -> employeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		Employee employeeDetail = employeeRepository.findById(employeeId).
				orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't exist for given Id:" + employeeId));
		
		employeeDetail.setFirstName(updatedEmployee.getFirstName());
		employeeDetail.setLastName(updatedEmployee.getLastName());
		employeeDetail.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employeeDetail);
		
		EmployeeMapper employeeMapper= new EmployeeMapper();
		return employeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId).
		orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't exist for given Id:" + employeeId));

		employeeRepository.deleteById(employeeId);
	}

}
