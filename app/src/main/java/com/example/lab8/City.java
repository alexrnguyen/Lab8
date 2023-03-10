package com.example.lab8;

public class City implements Comparable {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * This compares a city to another city and checks how similar they are
     * @param o
     *      A city to compare the city object that calls the function to
     * @return
     *      Return an integer representing how similar 2 cities are (0 means they are the same)
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
