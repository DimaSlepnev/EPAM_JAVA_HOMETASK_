package com.company.Homework3;

public class Task_3 {
    public static double MultArithmeticElements(double a1, double t, int n ){
        double res = 1;
        for (int i = 1; i <= n; i++){
            res *= a1;
            a1 +=t;
        }
        return res;
    }
    public static void main (String [] args){
        System.out.println(MultArithmeticElements(10.3,2.2,4));
    }
}
