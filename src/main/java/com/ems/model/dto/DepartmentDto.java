package com.ems.model.dto;

import java.util.Set;

import com.ems.model.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

	
	private Long id;
    private String name;
    private String headOfDepartment;
    private Set<Employee> employees;
}
