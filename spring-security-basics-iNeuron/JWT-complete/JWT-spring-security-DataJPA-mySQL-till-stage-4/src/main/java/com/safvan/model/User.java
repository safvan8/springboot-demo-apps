package com.safvan.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "tbl_security_users")
@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String username;
	private String password;

	@ElementCollection
	@CollectionTable(name = "tbl_security_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	@Column(name = "role")
	private Set<String> roles;
}
