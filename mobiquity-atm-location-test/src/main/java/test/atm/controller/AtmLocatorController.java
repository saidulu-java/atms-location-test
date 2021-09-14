package test.atm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import test.atm.client.AtmLocatorService;
import test.atm.dto.AtmDetail;

@RestController
@RequestMapping("/atms")
public class AtmLocatorController {

	@Autowired
	private AtmLocatorService service;

	@GetMapping("/list")
	public List<AtmDetail> getAllAtms() throws JsonMappingException, JsonProcessingException {

		return service.getAllAtmsDetails();
	}

	@GetMapping("/{city}")
	public List<AtmDetail> getAllAtmsByCity(@PathVariable String city)
			throws JsonMappingException, JsonProcessingException {

		System.out.println(city);
		List<AtmDetail> atmDetails = service.getAllAtmsDetails();

		List<AtmDetail> atmCityDetails = new ArrayList<AtmDetail>();
		for (AtmDetail root : atmDetails) {
			if (root.getAddress().getCity().equalsIgnoreCase(city)) {
				atmCityDetails.add(root);
			}
		}
		return atmCityDetails;
	}

}
