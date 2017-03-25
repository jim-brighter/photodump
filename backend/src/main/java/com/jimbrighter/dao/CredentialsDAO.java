package com.jimbrighter.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jimbrighter.entity.Credentials;

public interface CredentialsDAO extends JpaRepository<Credentials, Long> {
	Optional<Credentials> findOneByUsername(String username);
}
