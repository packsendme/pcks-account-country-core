package com.packsendme.microservice.country;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.microservice.country.service.*;
import com.packsendme.microservice.country.repository.*;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceCountryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCountryServerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(CountryService countryService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CountryModel>> typeReference = new TypeReference<List<CountryModel>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/resources/country.json");
			try {
				List<CountryModel> country = mapper.readValue(inputStream,typeReference);
				countryService.saveCountryList(country);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
