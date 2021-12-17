package com.company.lesson07.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumberController extends Number {
    private Number model;
    private NumberView view;

    public NumberController(Number model, NumberView view) {
        this.model = model;
        this.view = view;
    }

    public void setNumber(int min, int max) {
        model.setNumb(rand(min, max));
    }

    public int getNumber() {
        return model.getNumb();
    }

    public void setLowRange(int min) {
        model.setLowRange(min);
    }

    public int getLowRange() {
        return model.getLowRange();
    }

    public void setHigthRange(int max) {
        model.setHightRange(max);
    }

    public int getHightRange() {
        return model.getHightRange();
    }

    public int rand(int min, int max) {
        numb = (int) (Math.random() * ((max - min) + 1)) + min;
        return numb;
    }

    public boolean checkNumber(int userN) {
        if (numb == userN) {
            return true;
        } else
            return false;
    }

    public int checkHightRange(int userN) {
        if (userN > numb) {
            model.setHightRange(userN);
            return model.getHightRange();
        } else {
            return 100;
        }
    }

    public int checkLowRange(int userN) {
        if (userN < numb) {
            model.setLowRange(userN);
            return model.getLowRange();
        } else {
            return 0;
        }
    }

    public void updateEnterIntNumber(){
        view.EnterIntNumber();
    }

    public void updateView() {
        view.RangeInfo(model.getLowRange(), model.getHightRange());
    }

    public void updateEndOfGame(){
        view.EndOfGame(getCounter());
    }
    public void updateShowAttempts(){
        view.ShowAttempts(getCounter());
    }
    public void updateError(){
        view.Error();
    }

    public void ShowPreviousAttempts(int userN) {
        arr = newArr.clone();
        newArr = Arrays.copyOf(newArr,t+1);
        newArr[t] = userN;
        t++;
        arr = newArr.clone();
        for (var t :
                arr) {
            System.out.print(t + "\t");
        }
        count++;
        System.out.println("");
    }

    public void updatePlayAgain(){
        view.PlayAgain();
    }

    public void OneMoreTime(int userAnswer,int min,int max,Number n, NumberView nv, NumberController nc, int nextUserAnswer,User u,
                            UserView uv, UserController uc, Scanner sc ){
        model.setAnswer(userAnswer);
        if (model.getAnswer() == 1){
            MVCPatternDemo.Play(min,max,n,nv,nc,nextUserAnswer,u,uv,uc,sc);
        }
        else if (model.getAnswer() == 0){
            model.setWork(false);
        }
        else {
            view.Error();
        }
    }
}
