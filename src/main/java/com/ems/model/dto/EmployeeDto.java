package com.ems.model.dto;

import com.ems.model.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
	private Long id;
	private Department department;
	private String role;
	private String contactInfo;
	private String performanceReview;
	private Integer rating;
	private String review;
}
