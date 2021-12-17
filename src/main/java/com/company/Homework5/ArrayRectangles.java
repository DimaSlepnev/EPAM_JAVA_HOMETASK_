package com.company.Homework5;

import com.company.Homework5.*;

public class ArrayRectangles {
    private  Rectangle [] rectangle_array;
    public ArrayRectangles(int n){
        rectangle_array = new Rectangle[n];
    }
    public ArrayRectangles(Rectangle ... r){
        this (r.length);
        for (int i = 0; i < rectangle_array.length; i++ ){
            rectangle_array[i] = r[i];
        }
    }
    public boolean addRectangle(Rectangle r){
         for (int i = 0; i < rectangle_array.length; i++){
             if (rectangle_array[i] == null) {
                 rectangle_array[i] = r;
                 return true;
             }
         }
         return false;
    }
    public int numberMaxArea (){
        double maxArea = 0;
        int index = 0;
        for(int i = 0; i < rectangle_array.length; i++ ){
            if (rectangle_array[i].Area() > maxArea){
                maxArea = rectangle_array[i].Area();
                index = i;
            }
        }
        return index;
    }
    public int numberMinPerimetr(){
        double minPerimetr = Double.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < rectangle_array.length; i++){
            if (rectangle_array[i].Perimetr() < minPerimetr){
                minPerimetr = rectangle_array[i].Perimetr();
                index = i;
            }
        }
        return index;
    }
    public int numberSquare(){
        int count = 0;
        for(int i = 0; i < rectangle_array.length; i++){
            if (rectangle_array[i].isSquare()){
                count++;
            }
        }
        return count;
    }

    static public void main (String[] args){

    }
}
