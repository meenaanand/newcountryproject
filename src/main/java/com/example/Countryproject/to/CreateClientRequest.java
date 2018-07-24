package com.example.Countryproject.to;

import org.hibernate.validator.constraints.NotBlank;

public class CreateClientRequest {

    @NotBlank
    private String countryname;

    public CreateClientRequest(String countryname) {
        this.countryname = countryname;
    }

    public CreateClientRequest() {
    }
/**
 * @return the countryname
 */
public String getCountryname() {
    return countryname;
}
/**
 * @param countryname the countryname to set
 */
public void setCountryname(String countryname) {
    this.countryname = countryname;
}
  
}