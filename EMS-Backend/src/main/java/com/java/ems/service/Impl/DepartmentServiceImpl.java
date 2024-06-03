package com.java.ems.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.ems.dto.DepartmentDto;
import com.java.ems.entity.Department;
import com.java.ems.exception.ResourceNotFoundException;
import com.java.ems.mapper.DepartmentMapper;
import com.java.ems.repository.DepartmentRepository;
import com.java.ems.service.DepartmentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		DepartmentMapper departmentMapper= new DepartmentMapper();
		Department department= departmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return departmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		Department department = departmentRepository.findById(departmentId).
		orElseThrow(() -> new ResourceNotFoundException("Department doesn't exist with given id:" + departmentId));
		
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> allDepartment = departmentRepository.findAll();
		
		return allDepartment.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
		
	}

	@Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {

        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id:"+ departmentId)
        );

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
        );

        departmentRepository.deleteById(departmentId);
    }
	

}
