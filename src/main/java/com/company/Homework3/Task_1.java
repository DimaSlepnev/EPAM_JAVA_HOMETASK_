package com.company.Homework3;


public class Task_1 {
    public enum HowToSort {
    Ascending {
        public int[] sortArr(int[] arr) {
            int[] newArr = arr.clone();
            for (int i = 0; i < newArr.length; i++) {
                for (int j = 0; j < newArr.length - 1; j++)
                    if (newArr[j] > newArr[j + 1]) {
                        int temp = newArr[j];
                        newArr[j] = newArr[j + 1];
                        newArr[j + 1] = temp;
                    }
            }
            return newArr;
        }
    },
    Descending {
        public int[] sortArr(int[] arr) {
            int[] newArr = arr.clone();
            for (int i = 0; i < newArr.length; i++) {
                for (int j = 0; j < newArr.length - 1; j++)
                    if (newArr[j] < newArr[j + 1]) {
                        int temp = newArr[j + 1];
                        newArr[j + 1] = newArr[j];
                        newArr[j] = temp;
                    }
            }
            return newArr;
        }
    };

    public abstract int[] sortArr(int[] arr);
}
public static boolean isSorted(int [] arr, HowToSort value){
  if (value == HowToSort.Ascending){
      value.sortArr(arr);
      return true;
  }
  else {
      value.sortArr(arr);
      return false;
  }
  }
    public static void main(String [] args) {
      int [] arr = {1,6,2,3,8,5,7};
      boolean result = isSorted(arr, HowToSort.Ascending);
      if (result == true){
          System.out.println("Ascending");
      }
      else
          System.out.println("Descending");

    }
}
