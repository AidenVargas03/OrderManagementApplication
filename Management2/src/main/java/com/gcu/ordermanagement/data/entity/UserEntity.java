package com.gcu.ordermanagement.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("USER")
public class UserEntity {
	
	@Id
	Long Id;
	
	@Column("username")
	String username;
	
	@Column("password")
	String password;
	
	
	@Column("email")
	String email;
	
	
	
	public UserEntity(long inId, String inUsername, String inPassword, String inEmail) {
		setId(inId);
		setUsername(inUsername);
		setPassword(inPassword);
		setEmail(inEmail);
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserEntity() {
		
	}

}
