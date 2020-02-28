package io.java.praveen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.java.praveen.service.CoronaDataService;

@RestController
public class HomeController {
	@Autowired
	private CoronaDataService data;
	@GetMapping("/hello")
	public String hello() {
		return data.fetchData();
	}

}
