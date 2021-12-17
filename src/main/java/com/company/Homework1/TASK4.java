package com.company.Homework1;

public class TASK4 {
    public static void main(String[] args) {
    int n = 37;
    int x = 0;
    int numberOfOnes = 0;
    while (n > 0){
        x = n % 2;
        if (x == 1)
            numberOfOnes++;
        n/=2;
    }
    System.out.println(numberOfOnes);
}
}
