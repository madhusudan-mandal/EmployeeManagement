package com.ems.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.PackagePrivate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@Column(name="employee_id")
	private Long id;
	
	@Column(name="employe_name")
	private String name;

	@Column(name="employe_role")
	private String role;
	
	@Column(name="employe_phoneNumber")
	private String phoneNumber;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	private Integer rating;
	private String review;
}
