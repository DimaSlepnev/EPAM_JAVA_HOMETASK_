package com.company.Homework10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMDA {
    private List<User> users = new ArrayList<>();
    private int countOfMonth = 0;
    public  void GetUsersFromCSV( String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader( filename))) {
            br.readLine();
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(";");
                this.users.add(new User(words[0],words[1], Double.parseDouble(words[2].replace(",","."))));
            }
            countOfMonth++;
        }
    }

    public List<User> getUsers() {
        return users;
    }

     double MaxSalary(){
        double maxSalary = 0;
        for(int i = 0; i < users.size(); i++){
            if (users.get(i).getSalary() > maxSalary){
                maxSalary = users.get(i).getSalary();
            }
        }
        return maxSalary;
    }

     List<User> GetMinimumSalary(){
        double minSalary = users.get(0).getSalary();
        List<User> minSalaryList = new ArrayList<>();
        for(int i = 1; i < users.size(); i++){
            if(users.get(i).getSalary() < minSalary){
                minSalary = users.get(i).getSalary();
            }
        }
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getSalary() == minSalary){
                minSalaryList.add(users.get(i));
            }
        }
        return minSalaryList;
    }

     List<User> AverageSalaryAnd20Percent(){
        List<User> averageSalary = new ArrayList<>();
        double salary = 0;
        for (int i =0; i < users.size(); i++){
           salary += users.get(i).getSalary();
        }
        salary /= users.size();
        for (int i =0; i < users.size(); i++){
            if(users.get(i).getSalary() >= salary - salary/5 &&
                    users.get(i).getSalary() <= salary + salary/5){
                averageSalary.add(users.get(i));
            }
        }
        return averageSalary;
    }

     double [] AverageSalarySeveralMonth(){
        int peopleInOneMonth = users.size() / countOfMonth;
        double [] averageSalary = new double[users.size() / peopleInOneMonth];
        for (int i = 0; i < users.size()/peopleInOneMonth; i++ ) { // amount of months
            double salaryForMonth = 0;
            for (int j =0; j < peopleInOneMonth; j++){
                salaryForMonth+= users.get(i+j).getSalary();
            }
            averageSalary[i] = Double.parseDouble(String.valueOf((new BigDecimal(salaryForMonth / peopleInOneMonth).setScale(2,BigDecimal.ROUND_HALF_UP))));
        }
        return averageSalary;
    }

     int MaxAverageSalaryInMonth(){
        double [] arr = new double[AverageSalarySeveralMonth().length];
        arr = Arrays.copyOf(AverageSalarySeveralMonth(), arr.length);
        double max = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        return index + 1;
    }

    public void ShowMaxSalary(){
        System.out.println("Max salary is " + MaxSalary());
    }
    public void ShowMinimumSalary(){
        System.out.println("List of minimum salary:\n" + GetMinimumSalary());
    }
    public void ShowAverageSalary(){
        System.out.println("List of average salary and +-20%:\n" + AverageSalaryAnd20Percent());
    }
    public void ShowAverageSalaryPerMonth() {
        System.out.println("Averages salaries for " + countOfMonth + " month is: " + Arrays.toString(AverageSalarySeveralMonth()));
    }
    public void ShowIndexMaxAverageSalary(){
        System.out.println("Max average salary was in " + MaxAverageSalaryInMonth() + " month");
    }
}
