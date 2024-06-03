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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.ems.dto.DepartmentDto;
import com.java.ems.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentControllor {
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departementDto){
		DepartmentDto department = departmentService.createDepartment(departementDto);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@RequestParam Long departmentId){
		DepartmentDto departmentDtoById= departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(departmentDtoById);
		
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
		List<DepartmentDto> allDepartments = departmentService.getAllDepartments();
		return ResponseEntity.ok(allDepartments);
	}
	
    // Build Update Department REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully!.");
    }
	
}
