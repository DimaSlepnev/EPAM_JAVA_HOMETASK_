package com.company.World_Map.PL;

import com.company.World_Map.BLL.City;
import com.company.World_Map.BLL.Country;
import com.company.World_Map.BLL.WorldMap;
import com.company.World_Map.DAL.Load;
import com.company.World_Map.DAL.Save;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenu {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    WorldMap worldMap = new WorldMap();


    public void main() {
        while (true) {
            worldMap = Load.ReadMapFromXML();
            System.out.println("Choose action:\n" +
                    "1 - Find by unique ID\n" +
                    "2 - Operations with countries\n" +
                    "3 - Operations with cities\n" +
                    "4 - Show information\n" +
                    "Answer: ");
            try {

                String userAnswer = br.readLine();
                if (userAnswer.compareTo("1") == 0) {
                    findByID();
                }
                else if (userAnswer.compareTo("2") == 0) {
                    countriesOperations();
                    Save.WriteMapToXML(worldMap);
                }
                else if (userAnswer.compareTo("3") == 0) {
                    citiesOperations();
                    Save.WriteMapToXML(worldMap);
                }
                else if (userAnswer.compareTo("4") == 0) {
                    System.out.println(Load.ReadMapFromXML());
                } else
                    throw new IOException();
            } catch (IOException e) {
                errorMessage();
            }
        }
    }

    public void findByID() {
        System.out.println("Enter unique ID:(consist of 5 characters)");
        String inputUniqueID = null;
        String result = null;
        try {
            inputUniqueID = br.readLine();
            if (inputUniqueID.length() != 5) {
                System.out.println("Here not 5 characters");
                throw new IOException();
            }
            if (worldMap.searchCityByID(inputUniqueID) != null) {
                result = worldMap.searchCityByID(inputUniqueID);
                System.out.println(result);
            }
            else if (worldMap.searchCountryByID(inputUniqueID) != null) {
                result = worldMap.searchCountryByID(inputUniqueID);
                System.out.println(result);
            }
            if (result == null)
            {
                System.out.println("There are not country or city with it iD");
            }
        } catch (IOException e) {
            errorMessage();
        }
    }

    public void countriesOperations() {
        System.out.println("Choose action with country\n" +
                "1 - Show all countries\n" +
                "2 - Add country\n" +
                "3 - Remove country\n" +
                "4 - Edit country\n" +
                "Answer:");
        try {
            String userAnswer = br.readLine();
            if (userAnswer.compareTo("1") == 0) {
                showAllCountries();
                return;
            }
            if (userAnswer.compareTo("2") == 0) {
                countyAdder();
                Save.WriteMapToXML(worldMap);
                return;
            }
            if (userAnswer.compareTo("3") == 0) {
                countryRemover();
                Save.WriteMapToXML(worldMap);
                return;
            }
            if (userAnswer.compareTo("4") == 0) {
                countryEditor();
                Save.WriteMapToXML(worldMap);
                return;
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            errorMessage();
        }
    }

    public void showAllCountries() throws IOException {
        if (worldMap == null) {
            System.out.println("Map is empty. Immediately add country! ");
            countyAdder();
        } else {
            for (int i = 0; i < worldMap.worldMap.size(); i++) {
                System.out.println(i+1 + ") " + worldMap.getWorldMap().get(i).getName() + " | " + worldMap.getWorldMap().get(i).getUniqueID());
            }
        }
        }

    public void countyAdder() throws IOException {
        Controller controller = new Controller();
        String name = controller.nameController();
        String uniqueID = controller.uniqueIDMaker();
        worldMap.addCountry(new Country(name, uniqueID));
        System.out.println("Country was added");
    }

    public void countryRemover() throws IOException {
        showAllCountries();
        System.out.println("Enter ID of country, that u wand to delete:");
        int before = worldMap.getWorldMap().size();
        try {
            String inputID = br.readLine();
            if (inputID.length() != 5) {
                System.out.println("Here not 5 characters");
                throw new IOException();
            }
            worldMap.removeCountryFromMap(inputID);
            int after = worldMap.getWorldMap().size();
            if (before == after) {
                System.out.println("I did not find country with specified ID");
                throw new IOException();
            }
            System.out.println("Country was deleted");
            Save.WriteMapToXML(worldMap);
        } catch (IOException e) {
            errorMessage();
        }
    }

    public void countryEditor() throws IOException {
        showAllCountries();
        Controller controller = new Controller();
        System.out.println("Enter number of country, that u want to edit(U have access only to name):");
        try {
            int number = Integer.parseInt(br.readLine());
            if (number < 1 || number > worldMap.getWorldMap().size()) {
                throw new IndexOutOfBoundsException();
            }
            String name = controller.nameController();
            worldMap.getWorldMap().get(number - 1).setName(name);
            Save.WriteMapToXML(worldMap);
            System.out.println("Saved!");
        } catch (IOException | IndexOutOfBoundsException e) {
            errorMessage();
        }

    }

    public void citiesOperations() throws IOException {
        Country country = new Country(null, null);
        System.out.println("Chose number of country:");
        showAllCountries();
        System.out.println("Answer:");
        try {
            int number = Integer.parseInt(br.readLine());
            country = worldMap.getWorldMap().get(number - 1);
            System.out.println("Choose action with country\n" +
                    "1 - Show cities in country\n" +
                    "2 - Add city to country\n" +
                    "3 - Remove city from country\n" +
                    "4 - Edit city\n" +
                    "5 - Show all cities\n" +
                    "Answer:");
            String userAnswer = br.readLine();
            if (userAnswer.compareTo("1") == 0) {
                showCitiesInOneCountry(country);
            }
           else  if (userAnswer.compareTo("2") == 0) {
                cityAdder(country);
                Save.WriteMapToXML(worldMap);
                return;
           }
            else if (userAnswer.compareTo("3") == 0) {
                cityRemover(country);
                System.out.println("Deleted!");
                Save.WriteMapToXML(worldMap);
                return;
            }
            else if (userAnswer.compareTo("4") == 0) {
                cityEditorChooser(country);
            }
            else if (userAnswer.compareTo("5") == 0) {
                showAllCities();
            } else {
                throw new IOException();
            }
        } catch (IOException  | NumberFormatException e) {
            errorMessage();
        }
    }


    public void showAllCities() throws IOException {
        if (worldMap == null) {
            System.out.println("Map is empty. Immediately add country! ");
            countyAdder();
        } else {
            for (int i = 0; i < worldMap.getWorldMap().size(); i++) {
                for (Country country : worldMap.getWorldMap()) {
                    for (City city :country.cities) {
                        System.out.println(city.getName() + " | " + city.getUniqueID() + " | " + city.getPopulation() + " | " + city.isCapital());
                    }
                }
            }
        }
    }

    public void cityAdder(Country country) throws IOException {
        Controller controller = new Controller();
        String name = controller.nameController();
        String uniqueID = controller.uniqueIDMaker();
        int population = controller.populationController();
        boolean isCapital = controller.isCapitalController();
        country.addCity(new City(name, uniqueID, population, isCapital, country.getName()));
    }

    public void cityRemover(Country country) throws IOException {
        System.out.println("Enter number of city, that i want to delete:");
        showCitiesInOneCountry(country);
        System.out.println("Answer:");
        try{
            int number = Integer.parseInt(br.readLine());
            if (number < 1 || number > country.getCities().size()){
                throw new IOException();
            }
            country.getCities().remove(number - 1);
        } catch (IOException e){
            errorMessage();
        }
    }

    public void cityEditorChooser(Country country) throws IOException {
        System.out.println("Which city? (number)");
        showCitiesInOneCountry(country);
        System.out.println("Answer:");
        try {
            int number = Integer.parseInt(br.readLine());
            if (number < 1 || number > country.getCities().size()) {
                throw new IndexOutOfBoundsException();
            }
            cityEditor(country.getCities().get(number - 1));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            errorMessage();
        }
    }


    public void cityEditor(City city) {
        System.out.println("What do u want to change?\n" +
                "1 - City name\n" +
                "2 - City population\n" +
                "Answer: ");
        try{
            String answer = br.readLine();
            if (answer.compareTo("1") == 0){
                cityNameEditor(city);
            }
            else if(answer.compareTo("2") == 0){
                cityPopulationEditor(city);
            }
            else{
                throw new IOException();
            }
        } catch (IOException e){
            errorMessage();
        }
    }

    public void cityNameEditor(City city){
        Controller controller = new Controller();
        try {
            String name = controller.nameController();
            city.setName(name);
            Save.WriteMapToXML(worldMap);
        } catch (IOException e) {
            System.out.println("Found error. The name was remained");;
        }
    }

    public void cityPopulationEditor(City city){
        Controller controller = new Controller();
        try {
            int population = controller.populationController();
            city.setPopulation(population);
            Save.WriteMapToXML(worldMap);
        } catch (IOException e) {
            System.out.println("Found error. The population was remained");
        }
    }

    public void showCitiesInOneCountry(Country country) throws IOException {
     if(country.getCities().size() == 0) {
         System.out.println("Map has no cities in this country");
         cityAdder(country);
     }
     else{
         for (int i = 0; i < country.getCities().size(); i++) {
             System.out.println(i+1 + ") " + country.getCities().get(i).getName());
         }
     }
    }

    public static void errorMessage() {
        System.out.println("Ops. Here wrong data. Please try one more time:");
    }
}
