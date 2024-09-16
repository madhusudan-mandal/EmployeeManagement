package com.ems.service;

import java.util.List;

import com.ems.model.dto.DepartmentDto;

public interface DepartmentService {
	List<DepartmentDto> getAllDepartments();
	DepartmentDto getDepartmentById(Long id);
	DepartmentDto createDepartment(DepartmentDto departmentDto);
	DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
	void deleteDepartment(Long id);
}
