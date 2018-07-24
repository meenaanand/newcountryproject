package com.example.Countryproject.Controller;

import java.util.List;
// import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import com.example.Countryproject.Service.CountryService;
import com.example.Countryproject.model.Country;
import com.google.common.net.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

@RequestMapping("/country")
public class CountryController{
    @Autowired
    private CountryService countryservice;
	
    // private Country header;
    
    @RequestMapping(value="/test", method=RequestMethod.POST)
    public ResponseEntity<Country> saveCountry(@RequestBody  @Valid Country country){
        countryservice.saveCountry(country);
        return new ResponseEntity<Country>(country,HttpStatus.OK);
    }

    // @RequestMapping(value="/test",method = RequestMethod.POST)
    // public ResponseEntity<Country> saveCountry(@RequestBody @Valid CreateClientRequest  country) {
    //     Country countryy = countryservice.saveCountry(country.getCountryname());
    //     return ResponseEntity.status(HttpStatus.CREATED).body(country);
    // }



    @RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Country> deleteById(@PathVariable Long id) {
         HttpHeaders headers = new HttpHeaders();
        countryservice.delete(id);
       // headers.setContentType(MediaType.APPLICATION_BINARY);
      return new ResponseEntity<Country> (headers,HttpStatus.OK);
     }
    
    /*
    **
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
            LOG.info("FM response body : {}", response.getBody());
            LOG.info("FM response status : {}", response.getStatusCode());
   */
    @RequestMapping(value="/get",method = RequestMethod.GET)
	public List<Country> getCountry() {
		return countryservice.findAll();
	}
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Country getCountry(@PathVariable Long id) {
        return countryservice.getOne(id);
    }
    @RequestMapping(value = "/put/{id}", method = RequestMethod.POST)
    
    public ResponseEntity<?> updateFlight(@RequestBody Country flight, @PathVariable("id") Long id) {
        Country f1=flight;
        countryservice.updateCountry(f1, id);           
        return new ResponseEntity<Country>(HttpStatus.OK);

    }
	public Country updateCountry(Country country2, Long countryId) {
		return null;
	}
}
/*****************************************
 @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
public ResponseEntity<Void> deleteById(@PathVariable Long id) {
 try {
  countryservice.deleteById(id);
  return ResponseEntity.noContent().build();
 } catch (ResourceNotFoundException e) {
  return ResponseEntity.notFound().build();
 }
}
 */