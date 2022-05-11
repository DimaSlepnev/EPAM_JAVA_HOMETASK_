package advanced.java.ua.univer.practice7;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBInteraction db = new DBInteraction();
        db.createConnection();
        System.out.println("Films:");
        db.print(db.getAllFilms());
        System.out.println("Actors:");
        db.print(db.getAllActors());
        System.out.println("Films that was premiered this and last years:");
        db.print(db.selectFilmsThisAndLastDateOfProduction());
        String filmName = "The Big Lebowski";
        System.out.println("Actors that stared in " + filmName);
        db.print(db.ActorsInSpecifiedFilm(filmName));
        int times = 1;
        System.out.println("Actors that stared at less in " + times + " films");
        db.print(db.ActorsInFilmsNTimes(times));
        System.out.println("Actors that was directors at less one time");
        db.print(db.ActorsIsDirects());
        int years = 22;
        System.out.println("Delete films more than " + years + " years ago.");
        db.deleteFilmsMoreThanYearsAgo(years);
        System.out.println("We have:");
        db.print(db.getAllFilms());
        db.closeConnection();
    }
}
