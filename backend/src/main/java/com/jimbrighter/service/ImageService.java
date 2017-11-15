package com.jimbrighter.service;

import java.util.List;

import com.jimbrighter.entity.Image;

public interface ImageService {
	
	public List<Image> getAllImages();
	public Image getImage(long id);
	public Image addImage(Image image);
	public void deleteImages(List<Image> ids);
	public void updateImages(List<Image> images);

}
