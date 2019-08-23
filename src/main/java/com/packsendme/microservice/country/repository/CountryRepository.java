package com.packsendme.microservice.country.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CountryRepository extends MongoRepository<CountryModel, String>   {
	

    @Query("{'idcountry' : ?0, codcountry : {$eq: ?1}}")
	CountryModel findCountryByCodNumber(String idcountry,String codNumber);


}