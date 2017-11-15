package com.jimbrighter.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jimbrighter.entity.Image;
import com.jimbrighter.service.ImageService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ImageController {

	@Inject
	private ImageService imageService;
	
	@ApiOperation(value = "Retrieve all images")
	@RequestMapping(value = "/images", method = RequestMethod.GET, produces = "application/json")
	public List<Image> getImages() {
		return imageService.getAllImages();
	}
	
	@ApiOperation(value = "Save an image")
	@RequestMapping(value = "/images", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Image addImage(@RequestBody Image image) {
		return imageService.addImage(image);
	}
	
	@ApiOperation(value = "Get one image by ID")
	@RequestMapping(value = "/images/{id}", method = RequestMethod.GET, produces = "application/json")
	public Image getImage(@PathVariable(value = "id") String id) {
		return imageService.getImage(Long.parseLong(id));
	}
}
