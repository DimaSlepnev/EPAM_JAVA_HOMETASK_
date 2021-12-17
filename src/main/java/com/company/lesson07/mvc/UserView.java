package com.company.lesson07.mvc;

import java.util.ArrayList;

public class UserView extends User{
    public void ShowUsersArr(ArrayList<String> arr, ArrayList<Integer> arr1){
        for (int i = 0; i < arr.size(); i++){
            System.out.println(String.format("%d - %s. Record is equal: %d", i+1 ,arr.get(i), arr1.get(i)));
        }
    }
    public void WelcomeMessage(){
        System.out.println("Chose your name:");
    }
    public void PressToEnterNewUser(){
        System.out.println("Enter 0 to add new user");
    }
    public void EnterNewUser(){
        System.out.print("Enter user name (If i find any mistake, I will call your \"NoName\"): ");
    }
}
