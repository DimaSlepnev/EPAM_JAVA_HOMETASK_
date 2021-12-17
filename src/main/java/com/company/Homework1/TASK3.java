package com.company.Homework1;

public class TASK3 {
    public static void main(String[] args) {
        int n = 123;
        int x = 0;
        int y = 0;
        while ( n > 0){
            x = n%10;
            if (x % 2 == 1){
                y += x;
            }
            n /= 10;
        }
        System.out.println(y);
    }
}
