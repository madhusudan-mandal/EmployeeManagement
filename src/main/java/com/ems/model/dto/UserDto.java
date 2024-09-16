package com.ems.model.dto;

import java.util.Set;

import javax.swing.table.TableStringConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
	private String name;
	private Set<String> role;
}
