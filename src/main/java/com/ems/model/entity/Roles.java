package com.ems.model.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "users_role")
public class Roles {

	@Id
	@Column(name="role")
	private String name;
	
	@Column(name="desc")
	private String description;
	
	@ManyToMany
	private Set<User> users;
	
}
