package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
    * create a mocklist for my citylist
    * @return
    */

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
    * get the size of the list
    * increase the list by adding a new city
    * check if our current size matches the initial size plus one
    */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));

        assertEquals(list.getCount(),listSize + 1, "The city was not found in the list");
    }

    /**
     * makes a city, checks if it's already in before it's added,
     * adds it, and then checks again if it is in
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();

        City city = new City("Edmonton", "AB");

        assertFalse(list.hasCity(city));

        list.addCity(city);

        assertTrue(list.hasCity(city));
    }

    /**
     * makes a city, adds it to the list,
     * deletes it, and then checks if it is there
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();

        City city = new City("Edmonton", "AB");

        list.addCity(city);
        list.deleteCity(city);

        assertFalse(list.hasCity(city));
    }

    /**
     * counts, adds a city, counts, and then adds a second city, counts again
     * and then deletes a city, counting one more time
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();

        City city = new City("Edmonton", "AB");

        assertEquals(0, list.countCities());

        list.addCity(city);

        assertEquals(1, list.countCities());

        City city2 = new City("Calgary", "AB");

        list.addCity(city2);

        assertEquals(2, list.countCities());

        list.deleteCity(city2);

        assertEquals(1, list.countCities());
    }


}
