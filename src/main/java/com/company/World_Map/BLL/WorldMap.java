package com.company.World_Map.BLL;


import com.company.World_Map.PL.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorldMap implements Serializable {
    public List<Country> worldMap= new ArrayList();
    public WorldMap(){

    }

    public void addCountry(Country country){
        worldMap.add(country);
    }


    public void removeCountryFromMap(String uniqueID ){
        for (int i = 0; i < worldMap.size(); i++) {
            if(uniqueID.compareTo(worldMap.get(i).getUniqueID())==0){
                 worldMap.remove(i);
            }
        }
    }

    public String searchCityByID(String uniqueID){
        String result = null ;
        for (int i = 0; i < worldMap.size(); i++) {
            for (int j = 0; j < worldMap.get(i).getCities().size(); j++) {
                   if(uniqueID.compareTo(worldMap.get(i).getCities().get(i).getUniqueID()) == 0){
                       result = worldMap.get(i).getCities().get(i).toString();
                   }
            }
        }
        return result;
    }

    public String searchCountryByID(String uniqueID){
        String result = null;
        for(int i =0; i < worldMap.size(); i++){
            if(uniqueID.compareTo(worldMap.get(i).getUniqueID()) == 0){
                result = worldMap.get(i).toString();
            }
        }
        return result;
    }

    public String getsWorldMap(){
        return  toString();
    }

    public List<Country> getWorldMap() {
        return worldMap;
    }

   @Override
    public String toString() {
        String result = "\nWorldMap: " + worldMap + "\n";
        return result.replace("]","").replace("[", " ");
    }

}
