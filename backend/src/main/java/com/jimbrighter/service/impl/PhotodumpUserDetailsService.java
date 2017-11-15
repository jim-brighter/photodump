package com.jimbrighter.service.impl;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jimbrighter.entity.Credentials;
import com.jimbrighter.entity.wrapper.PhotodumpUserDetails;

@Service
public class PhotodumpUserDetailsService implements UserDetailsService {

	@Inject
	CredentialsService credentialsService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials credentials = credentialsService.getCredentialsByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("No credentials found for username %s", username)));
		return new PhotodumpUserDetails(credentials);
	}
}
