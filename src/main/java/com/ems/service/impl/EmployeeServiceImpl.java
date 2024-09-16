package com.ems.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.exception.ResourceNotFoundException;
import com.ems.model.dto.EmployeeDto;
import com.ems.model.entity.Employee;
import com.ems.repo.EmployeeRepo;
import com.ems.repo.UserRepo;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		if(userRepo.findById(employeeDto.getId())!=null)
			{
				Employee employee = convertToEntity(employeeDto);
				return convertToDto(employeeRepo.save(employee));
			}
		else {
			throw new ResourceNotFoundException("User does not exist");
		}
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		Employee employee = convertToEntity(employeeDto);
		employee = employeeRepo.findById(employee.getId())
				.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist"));
		employee.setDepartment(employeeDto.getDepartment());
		employee.setRole(employeeDto.getRole());
		employee.setPhoneNumber(employeeDto.getContactInfo());
		return convertToDto(employeeRepo.save(employee));
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No employee found"));
		return convertToDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Not Employee with given id found"));
		employeeRepo.delete(employee);
	}
	
	@Override
	public EmployeeDto updatePerformance(Long id, EmployeeDto employeeDto) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Not Employee with given id found"));
		employee.setRating(employeeDto.getRating());
		employee.setReview(employeeDto.getReview());
		return convertToDto(employeeRepo.save(employee));
	}
	
	
	public Employee convertToEntity(EmployeeDto employeeDto) {
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		return employee;
	}

	private EmployeeDto convertToDto(Employee emp) {
		EmployeeDto employeeDto = this.modelMapper.map(emp, EmployeeDto.class);
		return employeeDto;
	}


	
}
