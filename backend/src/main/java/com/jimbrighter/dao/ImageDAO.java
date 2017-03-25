package com.jimbrighter.dao;

import java.util.List;

import com.jimbrighter.entity.Image;

public interface ImageDAO {

	public Image getImage(long id);
	public List<Image> getAllImages();
	public boolean createImage(String title, String url, String submitter);
	public boolean deleteImage(long id);
	public boolean updateImage(Image image);
}
