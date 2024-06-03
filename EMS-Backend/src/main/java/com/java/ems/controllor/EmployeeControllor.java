package com.java.ems.controllor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.ems.dto.EmployeeDto;
import com.java.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControllor {
	public EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//Get Employee by employeeId
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto= employeeService.getemployeebyId(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployeeById(){
		List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
		return ResponseEntity.ok(allEmployee);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto employeeDto){
		EmployeeDto updateEmployee = employeeService.updateEmployee(employeeId, employeeDto);
		return ResponseEntity.ok(updateEmployee); 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee deleted successfullly!."); 
	}
}
