package com.company.Homework3;

import java.util.Scanner;

public class Task_4 {
    public static double SumGeometricElements(double a1, double t, double alim){
        double res = 0;
        if(alim > 1 && t < 1){
            for (double i = a1;i > alim; i *= t){
                res += a1;
                a1 *= t;
            }
            return res;
        }
        return 0;
    }
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        double answer;
        while (true) {
            System.out.print("Enter value \"a1\": ");
            double a1 = sc.nextDouble();
            System.out.print("Enter value \"t\": ");
            double t = sc.nextDouble();
            System.out.print("Enter value \"alim\": ");
            double alim = sc.nextDouble();
            answer = SumGeometricElements(a1, t, alim);
            if (answer == 0){
                System.out.println("Smt went wrong. Please, try one more time");
            }
            else{
                System.out.println(answer);
            }
        }

    }
}
