package com.company.World_Map.BLL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {
    Country germany;
    City bremen;

    @BeforeEach
    void setUp() {
        germany = new Country("Germany","50505");
        bremen = new City("Bremen","56450",1000000,false,"German");
        System.out.println("@Run Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@Run After");
    }

    @Test
    void addCity() {
        germany.addCity(bremen);
        assertEquals(1,germany.getCities().size());
    }
}