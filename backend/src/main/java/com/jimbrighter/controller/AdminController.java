package com.jimbrighter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jimbrighter.dao.ImageDAO;
import com.jimbrighter.entity.Image;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ImageDAO imgDAO;
	
	@ApiOperation(value = "Delete a list of images by IDs")
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> deleteImage(@RequestBody List<Long> ids) {
		for (Long id : ids) {
			if (!imgDAO.deleteImage(id)) {
				return new ResponseEntity<String>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update an image")
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> updateImage(@RequestBody List<Image> images) {
		for (Image i : images) {
			if (!imgDAO.updateImage(i)) {
				return new ResponseEntity<String>("FAILED", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<String>("ACCEPTED", HttpStatus.ACCEPTED);
	}
}
