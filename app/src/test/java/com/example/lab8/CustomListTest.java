package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    public City MockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(city);
        assertTrue(cityList.hasCity(city));
        City city2 = new City("Ottawa", "Ontario");
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDelete() {
        CustomList cityList = MockCityList();
        City city = MockCity();
        cityList.addCity(city);
        assertEquals(1, cityList.getCities().size());
        cityList.delete(city);
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void testDeleteException() {
        CustomList cityList = MockCityList();
        City city = MockCity();
        cityList.addCity(city);
        City newCity = new City("Calgary", "Alberta");
        cityList.delete(MockCity());
        assertEquals(0, cityList.getCities().size());
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(newCity));
    }

    @Test
    void testCountCities() {
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.countCities());
        City newCity = new City("Calgary", "Alberta");
        City anotherNewCity = new City("Vancouver", "British Columbia");
        cityList.addCity(newCity);
        cityList.addCity(anotherNewCity);
        assertEquals(2, cityList.countCities());
        City city = MockCity();
        cityList.delete(newCity);
        assertEquals(1, cityList.countCities());
    }


}
