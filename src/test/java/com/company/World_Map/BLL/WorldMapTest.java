package com.company.World_Map.BLL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorldMapTest {
    Country england;
    City liverpool;
    WorldMap worldMap;

    @BeforeEach
    void setUp() {
        System.out.println("@Run Before");
        england = new Country("England", "4a2s0");
        liverpool = new City("Liverpool","09gw2",2500000,false,"England" );
        england.addCity(liverpool);
        worldMap = new WorldMap();
        worldMap.addCountry(england);
    }

    @AfterEach
    void tearDown() {
        System.out.println("@Run After");
    }

    @Test
    void addCountry() {
        assertEquals(1, worldMap.getWorldMap().size());
    }

    @Test
    void removeCountryFromMap() {
        worldMap.removeCountryFromMap("4a2s0");
        assertEquals(0, worldMap.getWorldMap().size());
    }

    @Test
    void searchCityByID() {
        assertEquals("\nCity Liverpool:\n" +
                "uniqueID: 09gw2;\n" +
                "population: 2500000;\n" +
                "is capital: false;", worldMap.searchCityByID("09gw2"));
        assertEquals(null, worldMap.searchCityByID( "50505"));
    }

    @Test
    void searchCountryByID() {
        assertEquals(null, worldMap.searchCountryByID("645dsa"));
        assertEquals("\nCountry England\n" +
                "uniqueID: 4a2s0;\n" +
                "cities:\n" +
                "\n" +
                "City Liverpool:\n" +
                "uniqueID: 09gw2;\n" +
                "population: 2500000;\n" +
                "is capital: false;]", worldMap.searchCountryByID("4a2s0"));
    }

    @Test
    void getsWorldMap() {
        assertEquals("\nWorldMap:  \n" +
                "Country England\n" +
                "uniqueID: 4a2s0;\n" +
                "cities:\n" +
                "\n" +
                "City Liverpool:\n" +
                "uniqueID: 09gw2;\n" +
                "population: 2500000;\n" +
                "is capital: false;\n",worldMap.getsWorldMap());
    }
}