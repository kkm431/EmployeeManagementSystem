package com.java.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
