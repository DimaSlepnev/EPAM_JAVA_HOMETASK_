package com.company.Homework2;

public class Task_2 {

    public static void main(String[] args) {
        int[] arr = new int[]{10,4,26,3,10,14,26,5};
        int maxVal = arr[0];
        int rightCount = 0;
        int leftCount = 0;
        for (int i = 0; i < arr.length; i++ ){
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++ ){
            if (maxVal == arr[i]) {
                rightCount = i;
                break;
            }
        }
        for (int i = arr.length - 1; i > 0; i-- ){
            if (maxVal == arr[i]){
                leftCount = i;
                break;
            }
        }
        int result = leftCount - rightCount;

        System.out.println(result);
    }
}
