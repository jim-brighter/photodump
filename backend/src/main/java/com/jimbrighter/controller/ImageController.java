package com.jimbrighter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jimbrighter.dao.ImageDAO;
import com.jimbrighter.entity.Image;

import io.swagger.annotations.ApiOperation;

@RestController
public class ImageController {

	@Autowired
	private ImageDAO imgDAO;
	
	@ApiOperation(value = "Retrieve all images")
	@RequestMapping(value = "/images", method = RequestMethod.GET, produces = "application/json")
	public List<Image> getImages() {
		return imgDAO.getAllImages();
	}
	
	@ApiOperation(value = "Save an image")
	@RequestMapping(value = "/images", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> addImage(@RequestBody Image image) {
		if (imgDAO.createImage(image.getTitle(), image.getUrl(), image.getSubmitter())) {
			return new ResponseEntity<String>("ACCEPTED", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Get one image by ID")
	@RequestMapping(value = "/images/{id}", method = RequestMethod.GET, produces = "application/json")
	public Image getImage(@PathVariable(value = "id") String id) {
		return imgDAO.getImage(Long.parseLong(id));
	}
}
