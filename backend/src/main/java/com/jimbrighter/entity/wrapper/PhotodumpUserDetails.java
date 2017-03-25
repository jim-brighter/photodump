package com.jimbrighter.entity.wrapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.jimbrighter.entity.Credentials;
import com.jimbrighter.enums.RoleType;

public class PhotodumpUserDetails extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -98285830421163162L;
	private Credentials credentials;
	
	public PhotodumpUserDetails(Credentials credentials) {
		super(credentials.getUsername(), credentials.getPassHash(), AuthorityUtils.createAuthorityList(credentials.getRoleType().toString()));
		this.credentials = credentials;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}
	
	public Long getId() {
		return credentials.getId();
	}
	
	public RoleType getRoleType() {
		return credentials.getRoleType();
	}
	
}
