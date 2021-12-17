package com.company.Homework2;

public class Task_1 {
    public static void main(String[] args) {
        int arr[] = new int[]{4,3,10,2,6,8};
        int newArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[arr.length - 1 - i] % 2 == 0){
                newArr[i] = arr[arr.length - 1 - i];
                System.out.print(newArr[i] + "\t");
            }
            else
                System.out.print(arr[i] + "\t");
        }
    }
}
