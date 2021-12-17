package com.company.lesson07.mvc;

public class NumberView {
    public void RangeInfo (int lowRange, int hightRange) {
        System.out.println(String.format("Range changed to [%d;%d]", lowRange, hightRange));
    }
    public void EnterIntNumber(){
        System.out.println("Enter your number:");
    }
    public void EndOfGame(int count) {
        System.out.println(String.format("Congrats!!! U won! U spend %d attempts", count));
    }
    public void ShowAttempts(int count){
        System.out.println(String.format("Please try one more time. It's your %d's attempt", count));
    }
    public void Error(){
        System.out.println("Looks like there is a mistake in data. Try one time.");
    }
    public  void PlayAgain() {
        System.out.print("Do u wat one more time?\n1- yes; 0 - no\n");
    }
}
