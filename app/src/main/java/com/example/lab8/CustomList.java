package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public ArrayList<City> getCities() {
        ArrayList list = cities;
        Collections.sort(list);
        return list;
    }

    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the city
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This checks if CityList has a city
     * @param city
     *      This is a candidate city to search for in cities
     * @return
     *      Return True if cities has city, false otherwise.
     */
    public boolean hasCity(City city) {
        if(cities.contains(city)) {
            return true;
        }
        return false;
    }

    /**
     * This deletes a city from the list if the city is in the list
     * @param city
     *      This is a candidate city to delete
     */
    public void delete(City city) {
        boolean cityRemoved = false;
        int i = 0;
        while (i < cities.size()) {
            if (cities.get(i).compareTo(city) == 0) {
                cities.remove(0);
                cityRemoved = true;
            }
            i++;
        }
        if (!cityRemoved) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns the size of cities (same as count)
     * @return
     *      Return the size of the list cities
     */
    public int countCities() {
        return cities.size();
    }


}
