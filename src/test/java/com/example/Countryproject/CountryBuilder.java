package com.example.Countryproject;

import com.example.Countryproject.model.Country;

public class CountryBuilder {
    private Country country = new Country();

    public CountryBuilder countryid(Long countryid) {
        country.setCountryid(countryid);
        return this;
    }

    public CountryBuilder countryname(String countryname) {
        country.setCountryname(countryname);
        return this;
    }
    public Country build() {
        return country;
      }
}