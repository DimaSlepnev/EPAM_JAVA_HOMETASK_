package com.company.World_Map.BLL;

import com.company.Homework9.Matrix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;

public class City implements Serializable {
    private String name;
    private String uniqueID;
    private int population;
    private boolean isCapital;
    private String motherland;

    public String getUniqueID() {
        return uniqueID;
    }

    public City (){

    }
    public City(String name, String uniqueID ,int population, boolean isCapital, String motherland){
        setName(name);
        setUniqueID(uniqueID);
        setPopulation(population);
        setCapital(isCapital);
        setMotherland(motherland);
    }

    public int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        if (population < 0)
           population = Math.abs(population);
        if (population == 0) {
            System.out.println("We don`t need ghost city!");
            population = 500000;
        }
        this.population = population;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public String getName() {
        return name;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public String getMotherland() {
        return motherland;
    }

    public void setMotherland(String motherland) {
        this.motherland = motherland;
    }

    @Override
    public String toString() {
     String result ="\nCity " + this.getName()  +
                ":\nuniqueID: " + this.getUniqueID() +
                ";\npopulation: " + this.getPopulation() +
                ";\nis capital: " + this.isCapital() + ";";
     return result.replace("[","");
    }
}

