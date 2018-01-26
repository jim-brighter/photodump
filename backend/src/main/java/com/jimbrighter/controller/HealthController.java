package com.jimbrighter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class HealthController {

	@ApiOperation(value = "Check that the server is up")
	@RequestMapping(value = "/health", method = RequestMethod.GET, produces = "text/plain")
	public String status() {
		return "I'm here!";
	}
}
