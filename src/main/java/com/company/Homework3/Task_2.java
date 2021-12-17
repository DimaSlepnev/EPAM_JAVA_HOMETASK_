package com.company.Homework3;

import java.util.Arrays;
import com.company.Homework3.Task_1.HowToSort;

public class Task_2 {
    public static int[] Transform(int [] arr, Task_1.HowToSort value){
        int [] newArr = arr.clone();
        boolean Compare = false;
        if ((value == HowToSort.Ascending) && (Arrays.compare(arr,HowToSort.Descending.sortArr(arr)) == 0)){
            for (int i = 0; i < arr.length; i++){
               newArr[i] += i;
            }
             return newArr;

        }
        if((value == HowToSort.Descending) && (Arrays.compare(arr,HowToSort.Descending.sortArr(arr)) == 0)){
            for (int i = 0; i < arr.length; i++){
                newArr[i] += i;
            }
             return newArr;
        }
          int [] dupArr = {0};
        return dupArr;

    }
    public static void main (String [] args){
        int [] arr = {9,5,3,2,1};
        int [] secondArr = Transform(arr, HowToSort.Descending);
        for (int item:
             secondArr) {
            System.out.println(item);
        }
    }
}
