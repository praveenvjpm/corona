package io.java.praveen.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.java.praveen.dao.Data;
import io.java.praveen.service.CoronaDataService;
@CrossOrigin
@RestController
public class HomeController {
	@Autowired
	private CoronaDataService data;
	@GetMapping("/hello")
	public List<Data> hello() {
		System.out.println("Called All Reports");
		return data.dat;
	}
	
	@GetMapping("/country")
	public Map getCountryReport() {
		System.out.println("Country Report Called");
		return data.countryReport();
	}

}
