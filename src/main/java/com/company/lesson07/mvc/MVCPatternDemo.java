package com.company.lesson07.mvc;

import java.io.IOException;
import java.util.Scanner;


public class MVCPatternDemo {
    public static void Play(int min, int max,Number n, NumberView nv, NumberController nc, int userAnswer, User u, UserView uv, UserController uc, Scanner sc){
        nc.setNumber(min, max);
        nc.setLowRange(min);
        nc.setHigthRange(max);
        nc.setCounter(1);
        nc.setArr(new int[0]);
        nc.setNewArr(new int [0]);
        while (nc.getWork()) {
            try {
                uc.updateWelcomeMessage();
                uc.updateShowUsersArr();
                uc.updatePressToEnterNewUser();
                int addUser = sc.nextInt();
                if (addUser == 0) {
                    uc.updateEnterNewUser();
                    String newUser = sc.next();
                    uc.AddUser(newUser);
                    addUser = uc.users.size();
                }
                while (nc.getWork()){
                    nc.updateEnterIntNumber();
                    int userN = sc.nextInt();
                    if (userN >= nc.getLowRange() && userN <= n.getHightRange()) {
                        if (nc.checkNumber(userN)) {
                            nc.updateEndOfGame();
                            uc.CompareRecord(nc.getCounter(), addUser);
                            do {
                                try {
                                    nc.updatePlayAgain();
                                    userAnswer = sc.nextInt();
                                    if (userAnswer == 0) {
                                        nc.setWork(false);
                                        userAnswer = 0;
                                        break;
                                    }
                                    nc.OneMoreTime( userAnswer,min, max,n,nv,nc,100,u,uv,uc,sc);
                                } catch (Exception e) {
                                    nc.updateError();
                                    sc.nextLine();
                                }
                            } while (userAnswer != 1 || userAnswer != 0);
                        } else {
                            nc.checkLowRange(userN);
                            nc.checkHightRange(userN);
                            nc.updateView();
                            nc.ShowPreviousAttempts(userN);
                            nc.updateShowAttempts();
                        }
                    }
                }
            } catch (Exception e) {
                nc.updateError();
                sc.nextLine();
            }
        }
    }
    public static void main() {
        int max = 100;
        int min = 0;
        Number n = new Number();
        NumberView nv = new NumberView();
        NumberController nc = new NumberController(n, nv);
        User u = new User();
        UserView uv = new UserView();
        UserController uc = new UserController(u, uv);
        Scanner sc = new Scanner(System.in);
        nc.setNumber(min, max);
        nc.setLowRange(min);
        nc.setHigthRange(max);
        nc.setWork(true);
        int userAnswer = 100;
        uc.DefaultUsers();
        Play(min,max,n,nv,nc,userAnswer,u,uv,uc,sc);

    }
}
