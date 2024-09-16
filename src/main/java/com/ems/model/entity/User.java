package com.ems.model.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private Long userId;
	
	@Column(name="UserName", nullable = false)
	private String userName;
	
	@Column(name="UserPassword", nullable = false)
	private String userPassword;
	
	@ManyToMany(mappedBy = "users")
	private Set<Roles> roles;
	
}
