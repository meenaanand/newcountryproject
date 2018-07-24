package com.example.Countryproject.Repository;

import java.util.List;

import com.example.Countryproject.model.Country;
import com.google.common.base.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

	// Country getOne(long id);

// Optional<Country> findOne(long id);

	//  void delete(long id);


	// void deleteAll(long id);


    
    }