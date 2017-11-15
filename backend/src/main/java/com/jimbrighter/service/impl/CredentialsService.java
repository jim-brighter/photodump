package com.jimbrighter.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jimbrighter.dao.CredentialsDAO;
import com.jimbrighter.entity.Credentials;

@Service
public class CredentialsService {

	@Inject
	CredentialsDAO credentialsDAO;
	
	public Optional<Credentials> getCredentialsByUsername(String username) {
		return credentialsDAO.findOneByUsername(username);
	}
}
