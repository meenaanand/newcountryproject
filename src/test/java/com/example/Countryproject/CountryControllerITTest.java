package com.example.Countryproject;

import com.example.Countryproject.Repository.CountryRepository;
import com.example.Countryproject.model.Country;

import static com.jayway.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import static com.jayway.restassured.RestAssured.when;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

// import com.jayway.restassured.RestAssured;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = CountryprojectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")

public class CountryControllerITTest {

    // private static final String NAME_FIELD = "date";
    private static final String countryurl1 = "/country/get";
    private static final String countryurl2 = "/country/test";
    private static final String countryurl3 = "/country/put/{id}";
    private static final String countryurl4 = "/country/delete/{id}";
    private static final Long EVENT_ID = 1L;
    private static final Country country1 = new CountryBuilder().countryid(EVENT_ID).countryname("india").build();
    private static final Country country2 = new CountryBuilder().countryid(EVENT_ID).countryname("india").build();
    @Autowired
    private CountryRepository countryRepository;

    @Value("${local.server.port}")
    private int serverPort;
    private Country firstCountry;

    @Before
    public void setUp() {
        countryRepository.deleteAll();
        firstCountry = countryRepository.save(country1);
        RestAssured.port = serverPort;
    }

    @Test
    // SAVE
    public void addItemShouldReturnSavedItem() {
        given().body(country2).contentType(ContentType.JSON).when().post(countryurl2).then();
    }

    @Test
    public void updateItemShouldReturnUpdatedItem() {
        given().body(country2).contentType(ContentType.JSON)
        .when().put(countryurl3, firstCountry.getCountryid()).then();
        System.out.println("success");
    }

    @Test
    // GET ALL EVENTS
    public void getItemsShouldReturnBothItems() {
        when().get(countryurl1).then();
    }

    @Test
    // DELETE
    public void deleteItemShouldReturnNoContent() {
        when().delete(countryurl4, firstCountry.getCountryid()).then();
    }
}