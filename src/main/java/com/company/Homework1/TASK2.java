package com.company.Homework1;

public class TASK2 {
    public static void main(String[] args) {
        int n = 545;
        int x = 0;
        int y = 0;
        x = n % 10;
        n /= 10;
        y = n % 10;
        n /= 10;
        if (n >= y && n >= x) {
            if (y >= x) {
                System.out.println(String.format("%d%d%d", n, y, x));
            } else
                System.out.println(String.format("%d%d%d", n, x, y));
        }
        else if (y >= n && y >= x) {
            if (n >= x) {
                System.out.println(String.format("%d%d%d", y, n, x));
            } else
                System.out.println(String.format("%d%d%d", y, x, n));
        }
        else if (x >= n && x >= y) {
            if (n >= y) {
                System.out.println(String.format("%d%d%d", x, n, y));
            } else
                System.out.println(String.format("%d%d%d", x, y, n));
        }
    }
}
