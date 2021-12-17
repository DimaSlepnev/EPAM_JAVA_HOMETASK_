package com.company.Homework2;

public class Task_3 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2, 6, 7, 8},
                {1, 6, 3, 7},
                {6, 5, 3, 7},
                {6, 5, 9, 2}
        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j > i) {
                    arr[i][j] = 1;
                } else if (i > j) {
                    arr[i][j] = 0;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
