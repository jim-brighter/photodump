package com.jimbrighter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimbrighter.dao.CredentialsDAO;
import com.jimbrighter.entity.Credentials;

@Service
public class CredentialsService {

	@Autowired
	CredentialsDAO credentialsDAO;
	
	public Optional<Credentials> getCredentialsByUsername(String username) {
		return credentialsDAO.findOneByUsername(username);
	}
}
