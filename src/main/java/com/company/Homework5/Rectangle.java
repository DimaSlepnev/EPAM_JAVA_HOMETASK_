package com.company.Homework5;

public class Rectangle {
    private double sideA;
    private double sideB;
    public Rectangle(double a, double b){
        sideA = a;
        sideB = b;
    }
    public Rectangle(double a){
        this (a,5);
    }
    public Rectangle(){
        this (4,3);
    }
    public double getSideA(){
        return sideA;
    }
    public double getSideB(){
        return sideB;
    }
    public double Area(){
        return sideA * sideB;
    }
    public double Perimetr() {
        return 2 * (sideA + sideB);
    }
    public boolean isSquare(){
        if (sideA == sideB){
            return true;
        }
        else {
            return false;
        }
    }
    public void replaceSides(){
        double t = sideA;
        sideA = sideB;
        sideB = t;
    }

    static public void main (String[] args){

    }
}
