package com.ems.service;

import java.util.List;
import java.util.function.LongFunction;

import com.ems.model.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long id);
	List<EmployeeDto> getAllEmployee();
	void deleteEmployee(Long Id);
	
	EmployeeDto updatePerformance(Long id, EmployeeDto employeeDto);
	
	
}
