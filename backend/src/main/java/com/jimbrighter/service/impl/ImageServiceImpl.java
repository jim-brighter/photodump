package com.jimbrighter.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jimbrighter.dao.ImageDAO;
import com.jimbrighter.entity.Image;
import com.jimbrighter.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Inject
	private ImageDAO imageDAO;

	@Override
	@Transactional
	public List<Image> getAllImages() {
		return imageDAO.findAll();
	}

	@Override
	@Transactional
	public Image getImage(long id) {
		return imageDAO.findById(id);
	}

	@Override
	@Transactional
	public Image addImage(Image image) {
		image = imageDAO.saveAndFlush(image);
		return image;
	}

	@Override
	@Transactional
	public void deleteImages(List<Image> images) {
		imageDAO.delete(images);
	}

	@Override
	@Transactional
	public void updateImages(List<Image> images) {
		imageDAO.save(images);
	}
}
