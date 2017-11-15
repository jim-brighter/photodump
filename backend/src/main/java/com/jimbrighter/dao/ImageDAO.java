package com.jimbrighter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jimbrighter.entity.Image;

public interface ImageDAO extends JpaRepository<Image, Long>{

	public Image findById(long id);

}
