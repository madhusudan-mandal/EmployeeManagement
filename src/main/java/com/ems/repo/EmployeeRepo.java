package com.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.model.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartmentId(Long departmentId);
}
