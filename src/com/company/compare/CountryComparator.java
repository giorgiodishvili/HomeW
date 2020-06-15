package com.company.compare;

import com.company.Country;

import java.util.Comparator;


public interface CountryComparator {
    class ByName implements Comparator<Country> {
        @Override
        public int compare(Country country, Country country1) {
            return country.getName().compareTo(country1.getName());
        }
    }

    class ByPopulation implements Comparator<Country> {
        @Override
        public int compare(Country country, Country country1) {
            return Double.compare(country.getPopulation(), country1.getPopulation());
        }
    }

    class ByArea implements Comparator<Country> {
        @Override
        public int compare(Country country, Country country1) {
            return Double.compare(country.getArea(), country1.getArea());
        }
    }

}
