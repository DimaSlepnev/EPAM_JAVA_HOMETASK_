package com.company.lesson07.mvc;

public class User {
     String name;
     int bestTry;

   User(String name){
       this.name = name;
   }
   public User(){

   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBestTry() {
        return bestTry;
    }

    public void setBestTry(int bestTry) {
        this.bestTry = bestTry;
    }


}
