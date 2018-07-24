package com.example.Countryproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import com.example.Countryproject.Controller.CountryController;
import com.example.Countryproject.Repository.CountryRepository;
import com.example.Countryproject.model.Country;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

// @RunWith(MockitoJUnitRunner.class)

@RunWith(MockitoJUnitRunner.class)

public class CountryControllerTest {

    @InjectMocks
    private CountryController countryController;
    @Mock
    private CountryRepository countryRepository;

    public static List<Country> expectedCountries;

    @Test
    public void findCountryTest() {
        // Assign
        // Long countryId=1L;

        Country country1 = new Country(1L, "india");
        Country country2 = new Country(2L, "america");
        expectedCountries = Arrays.asList(country1, country2);
        when(countryRepository.findAll()).thenReturn(expectedCountries);
        // Action

        List<Country> actualCountries = countryRepository.findAll();
        // List<Country> actualCountries = expectedCountries;
        System.out.println("111" + actualCountries);
        // Assert-
        assertNotNull(actualCountries);
        assertEquals(2, actualCountries.size());
        assertEquals(expectedCountries, actualCountries);
    }

    @Test
    public void findoneTest() {
        // Assign
        Long countryId = 1L;
        Country country1 = new Country(1L, "india");
        when(countryRepository.getOne(countryId)).thenReturn(country1);
        // Action
        Country country = countryRepository.getOne(countryId);
        Long counid = country.getCountryid();
        System.out.println("111111111" + counid);
        // Assert-
        assertNotNull(country);
    }

    @Test
    public void addCountryTest() {

        Country country1 = new Country();
        country1.setCountryname("india");
        Country country2 = new Country(1L, "india");
        when(countryRepository.saveAndFlush(country1)).thenReturn(country2);
        Country AR = countryRepository.saveAndFlush(country1);
        // assertEquals(, AR.getBody());
        assertNotNull(AR);
    }

    @Test
    public void deleteCountryTest() {
        Long countryId = 2L;

        countryRepository.deleteById(countryId);
        verify(countryRepository).deleteById(countryId);

    }
}
