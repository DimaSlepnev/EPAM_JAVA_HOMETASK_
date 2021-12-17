package com.company.World_Map.PL;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

public class Controller {
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String nameController() throws IOException {
        String name = "default";
        while (true) {
            System.out.println("Enter a name:");
            name = br.readLine();
            if (!(name.matches("^[A-Z]{1}[a-z]+$"))) {
                ConsoleMenu.errorMessage();
            } else {
                break;
            }
        }
        return name;
    }

    public String uniqueIDMaker() {
        String uniqueID = UUID.randomUUID().toString().substring(0, 5);
        return uniqueID;
    }

    public int populationController() throws IOException {
        try {
            System.out.println("Enter population:");
            int population = Integer.parseInt(br.readLine());
            return population;
        } catch (NumberFormatException e) {
            System.out.println("This is not integer");
            populationController();
        }
        return 0;
    }

    public boolean isCapitalController() throws IOException {
        String str;
        boolean isCapital;
        while (true) {
            System.out.println("Is it a capital (+ for yes | - for no)");
            str = br.readLine();
            if (str.compareTo("+") == 0 || str.compareTo("-") == 0) {
                if (str.compareTo("+") == 0) {
                    isCapital = true;
                    break;
                } else {
                    isCapital = false;
                    break;
                }
            } else {
                ConsoleMenu.errorMessage();
            }
        }
        return isCapital;
    }

}
