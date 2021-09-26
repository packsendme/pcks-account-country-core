package com.packsendme.microservice.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.microservice.country.dto.CountryDto;
import com.packsendme.microservice.country.service.CountryService;


@RestController
@RequestMapping("/account/country")
public class CountryController {

	
	@Autowired
	private CountryService countryService; 
	
	
	//** BEGIN OPERATION: PAYMENT METHOD *************************************************//

	@PostMapping("/")
	public ResponseEntity<?> addCountry(@Validated @RequestBody CountryDto countryDto) throws Exception {
		return countryService.saveCountry(countryDto);
	}


	@GetMapping("/")
	public ResponseEntity<?> loadCountries() throws Exception {
		return countryService.getCountriesAll();
	}

	@GetMapping("/{idcountry}")
	public ResponseEntity<?> changePaymentMethod(
			@Validated @PathVariable ("idcountry") String idcountry) throws Exception {
		return countryService.getCountryByCod(idcountry);
	}
	
	
	//** BEGIN OPERATION: PAYMENT  *************************************************//


}
