package com.jimbrighter.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jimbrighter.entity.Image;
import com.jimbrighter.service.ImageService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Inject
	private ImageService imageService;
	
	@ApiOperation(value = "Delete a list of images by IDs")
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json")
	public void deleteImage(@RequestBody List<Image> images) {
		imageService.deleteImages(images);
	}
	
	@ApiOperation(value = "Update an image")
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public void updateImage(@RequestBody List<Image> images) {
		imageService.updateImages(images);
	}
}
