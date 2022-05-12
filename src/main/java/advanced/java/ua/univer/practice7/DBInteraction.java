package advanced.java.ua.univer.practice7;

import advanced.java.ua.univer.practice7.subject_area.Actor;
import advanced.java.ua.univer.practice7.subject_area.FilmDTO;

import java.sql.*;
import java.util.*;

public class DBInteraction {
    private final ResourceBundle resource = ResourceBundle.getBundle("database");
    private final String url = resource.getString("db.url");
    private final String user = resource.getString("db.user");
    private final String password = resource.getString("db.password");
    private Connection connection = null;
    private PreparedStatement pst = null;

    public void createConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public void print(List list) {
        if (list.size() == 0) {
            System.out.println("No such elements");
        } else {
            System.out.println(list.toString().replace('[', ' ').replace(']', ' '));
        }
    }

    public List<FilmDTO> getAllFilms() throws SQLException {
        List<FilmDTO> films = new ArrayList<>();
        pst = connection.prepareStatement("SELECT * FROM films");
        ResultSet rs = pst.executeQuery();
        filmListMaker(rs, films);
        return films;
    }

    public List<Actor> getAllActors() throws SQLException {
        List<Actor> actors = new ArrayList<>();
        pst = connection.prepareStatement("SELECT * FROM actors");
        ResultSet rs = pst.executeQuery();
        actorsListMaker(rs, actors);
        return actors;
    }

    public List<FilmDTO> selectFilmsThisAndLastDateOfProduction() throws SQLException {
        List<FilmDTO> filmsThatProductIn22Or21 = new ArrayList<>();
        Calendar calendar = new GregorianCalendar(2021, Calendar.JANUARY, 1);
        pst = connection.prepareStatement("SELECT * FROM films WHERE DATE(Date_Prodaction) > '" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "'");
        ResultSet rs = pst.executeQuery();
        filmListMaker(rs, filmsThatProductIn22Or21);
        return filmsThatProductIn22Or21;
    }

    public List<Actor> ActorsInSpecifiedFilm(String FilmName) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        pst = connection.prepareStatement("SELECT actors.Id,FIO,Birthdate FROM actors JOIN film_actors fa ON actors.Id = fa.Actor_Id " +
                "JOIN films f ON fa.Film__Id = f.Id WHERE Film_Name = '" + FilmName + "'");
        ResultSet rs = pst.executeQuery();
        actorsListMaker(rs, actors);
        return actors;
    }

    public List<Actor> ActorsInFilmsNTimes(int n) throws SQLException {
        List<Actor> actors = new ArrayList<>();
        pst = connection.prepareStatement("SELECT Id, FIO, Birthdate, COUNT(Film__id) Film_amount FROM film_actors " +
                "JOIN actors ON Actor_id = id " +
                "GROUP BY Id " +
                "HAVING Film_amount >= " + n);
        ResultSet rs = pst.executeQuery();
        actorsListMaker(rs, actors);
        return actors;
    }

    public List<Actor> ActorsIsDirects() throws SQLException {
        List<Actor> actors = new ArrayList<>();
        pst = connection.prepareStatement("SELECT * FROM actors JOIN film_directors fd ON actors.Id = fd.Actor_Id " +
                "JOIN films ON fd.Film_ID = films.Id ");
        ResultSet rs = pst.executeQuery();
        actorsListMaker(rs, actors);
        return actors;
    }

    public void deleteFilmsMoreThanYearsAgo(int years) throws SQLException {
        Calendar calendar = new GregorianCalendar(2022 - years, Calendar.JANUARY, 1);
        pst = connection.prepareStatement("DELETE f,fa,fd FROM films f JOIN film_actors fa ON f.Id = fa.Film__id " +
                "JOIN film_directors fd ON f.Id = fd.Film_Id " +
                "WHERE DATE(Date_Prodaction) < '" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + 1 + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "'");
        pst.execute();
    }

    private List<FilmDTO> filmListMaker(ResultSet rs, List<FilmDTO> films) throws SQLException {
        while (rs.next()) {
            FilmDTO film = new FilmDTO(rs.getInt("Id"), rs.getString("Film_Name"), rs.getDate("Date_Prodaction"), rs.getString("Country"));
            films.add(film);
        }
        return films;
    }

    private List<Actor> actorsListMaker(ResultSet rs, List<Actor> actors) throws SQLException {
        while (rs.next()) {
            Actor actor = new Actor(rs.getInt("Id"), rs.getString("FIO"), rs.getDate("Birthdate"));
            actors.add(actor);
        }
        return actors;
    }
}

