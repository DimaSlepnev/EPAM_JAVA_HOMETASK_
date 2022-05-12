package advanced.java.ua.univer.practice8;


import advanced.java.ua.univer.practice8.DAO_Level.ActorDAO;
import advanced.java.ua.univer.practice8.DAO_Level.FilmDAO;


public class Main {
    public static void main(String[] args) {
        FilmDAO films = new FilmDAO();
        System.out.println("Films:");
        System.out.println(films.findAll());
        ActorDAO actors = new ActorDAO();
        System.out.println("Actors:");
        System.out.println(actors.findAll());
        System.out.println("Films that was premiered this and last years:");
        System.out.println(films.findFilmsThisAndLastYears());
        String filmName = "The Big Lebowski";
        System.out.println("Actors that stared in " + filmName);
        System.out.println(actors.actorsInSpecifiedFilm(filmName));
        int times = 1;
        System.out.println("Actors that stared at less in " + times + " films");
        System.out.println(actors.actorsInFilmsNTimes(times));
        System.out.println("Actors that was directors at less one time");
        System.out.println(actors.actorsIsDirectors());
        int years = 22;
        System.out.println("Delete films more than " + years + " years ago.");
        films.deleteFilmsMoreThanNYearsAgo(22);
        System.out.println("We have: ");
        System.out.println(films.findAll());

    }
}
