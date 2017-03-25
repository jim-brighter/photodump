package com.jimbrighter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jimbrighter.enums.RoleType;

@Entity
@Table(name = "CREDENTIALS")
public class Credentials {

	@Id
	@SequenceGenerator(name = "creds_gen", sequenceName = "CREDS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "creds_gen")
	@Column(name = "CREDS_ID")
	private long id;
	
	@Column(name = "CREDS_USERNAME")
	private String username;
	
	@Column(name = "CREDS_PW_HASH")
	private String passHash;
	
	@Column(name = "CREDS_ROLE")
	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	
	
}
