package com.company.World_Map.BLL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable {
   private String name;
   private String uniqueID;
   public List<City> cities = new ArrayList<>();

   public Country( String name, String uniqueID){
       setName(name);
       setUniqueID(uniqueID);
   }

    public void addCity(City city){
        cities.add(city);
    }

    public List<City> getCities(){
       return cities;
    }

    public Country(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }



    @Override
    public String toString() {
        String result =  "\nCountry " + name +
                "\nuniqueID: " + uniqueID +
                ";\ncities:\n" + cities;
      return result.replace("[","");
    }
}
