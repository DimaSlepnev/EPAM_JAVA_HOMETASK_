package com.company.lesson07.mvc;

import java.util.ArrayList;
import java.util.Arrays;

public class UserController extends User {
    User model;
    UserView view;
    User us1 = new User("Mike");
    User us2 = new User("Kate");
    User us3 = new User("Heisenberg");
    ArrayList<String> users = new ArrayList<String>();
    Number numb1 = new Number();
    Number numb2 = new Number();
    Number numb3 = new Number();
    ArrayList<Integer> records = new ArrayList<Integer>();

    public UserController (User model, UserView view){
        this.model = model;
        this.view = view;
    }
    public void setName(String name){
        model.setName(name);
    }
    public String getName(){
        return model.getName();
    }

    public void DefaultUsers(){
        users.add(us1.getName());
        numb1.setCounter(5);
        records.add(numb1.getCounter());
        users.add(us2.getName());
        numb2.setCounter(7);
        records.add(numb2.getCounter());
        users.add(us3.getName());
        numb3.setCounter(10);
        records.add(numb3.getCounter());
    }
    public void updateShowUsersArr(){
        view.ShowUsersArr(users, records );
    }
    public void AddUser(String newName){
        User us4 = new User();
        Number numb4 = new Number();
        if  (newName.matches("^[A-Z]{1}[a-z]+$")) {
            us4.setName(newName);
            numb4.setCounter(100);
            users.add(us4.getName());
            records.add(numb4.getCounter());
       }
       else {
           newName = "NoName";
            numb4.setCounter(100);
           us4.setName(newName);
           users.add(us4.getName());
           records.add(numb4.getCounter());
       }
       view.ShowUsersArr(users,records);
    }

    public void CompareRecord(int newRecord, int x){
        if (newRecord < records.get(x - 1)){
            records.remove(x - 1);
            records.add(x-1 ,newRecord);
        }
    }

    public void updateWelcomeMessage(){
        view.WelcomeMessage();
    }
    public void updatePressToEnterNewUser(){
        view.PressToEnterNewUser();
    }
    public void updateEnterNewUser(){
        view.EnterNewUser();
    }

}
