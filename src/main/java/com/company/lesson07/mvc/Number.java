package com.company.lesson07.mvc;

import java.sql.SQLOutput;

public class Number {
    int numb;
    int lowRange;
    int hightRange;
    int t = 1;
    int[] arr = new int[0];
    int[] newArr = new int[0];
    int count = 1;
    int answer;
    boolean work;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getNewArr() {
        return newArr;
    }

    public void setNewArr(int[] newArr) {
        this.newArr = newArr;
    }

    public int getNumb() {
        return numb;
    }
    public void setNumb(int numb) {
        this.numb = numb;
    }

    public int getLowRange() {
        return lowRange;
    }
    public void setLowRange(int lowRange) {
        this.lowRange = lowRange;
    }

    public int getHightRange() {
         return hightRange;
    }
    public void setHightRange(int hightRange) {
        this.hightRange = hightRange;
    }

    public int getCounter() {
        return count;
    }
    public void setCounter(int count) {
        this.count = count;
    }

    public int getAnswer(){
        return answer;
    }
    public void setAnswer(int answer){
        this.answer = answer;
    }

    public boolean getWork(){
        return work;
    }
    public void setWork(boolean work){
        this.work = work;
    }
}

