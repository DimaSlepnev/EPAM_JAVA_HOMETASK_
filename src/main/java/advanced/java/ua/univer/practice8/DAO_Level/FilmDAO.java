package advanced.java.ua.univer.practice8.DAO_Level;

import advanced.java.ua.univer.practice8.ConnectionPool;
import advanced.java.ua.univer.practice8.DOT_Level.FilmDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FilmDAO implements DAO<FilmDTO, Integer> {
    private static ConnectionPool cn;
    private PreparedStatement pst = null;
    private Statement st = null;

    static {
        try {
            cn = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(FilmDTO film) {
        boolean result = false;
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.CREATE_FILM.QUERY);
            pst.setInt(1, film.getId());
            pst.setString(2, film.getName());
            pst.setDate(3, (Date) film.getDateOfProduction());
            pst.setString(4, film.getCountry());
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public List<FilmDTO> findAll() {
        List<FilmDTO> films = new ArrayList<>();
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.FIND_ALL_FILMS.QUERY);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                FilmDTO film = new FilmDTO(rs.getInt("Id"), rs.getString("FIlm_Name"), rs.getDate("Date_Prodaction"), rs.getString("Country"));
                films.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return films;
    }

    @Override
    public FilmDTO findEntityById(Integer id) {
        FilmDTO film = new FilmDTO(-1, null, null, null);
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.FIND_FILM_By_ID.QUERY);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                film = new FilmDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return film;
    }

    @Override
    public boolean update(FilmDTO film) {
        boolean result = false;
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.UPDATE.QUERY);
            pst.setString(1, film.getName());
            pst.setDate(2, (Date) film.getDateOfProduction());
            pst.setString(3, film.getCountry());
            pst.setInt(4, film.getId());
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public boolean deleteById(Integer id) {
        boolean result = false;
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.DELETE_BY_ID.QUERY);
            pst.setInt(1, id);
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public boolean delete(FilmDTO film) {
        boolean result = false;
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.DELETE_FILM.QUERY);
            pst.setInt(1, film.getId());
            pst.setString(2, film.getName());
            pst.setDate(3, (Date) film.getDateOfProduction());
            pst.setString(4, film.getCountry());
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    public List<FilmDTO> findFilmsThisAndLastYears() {
        List<FilmDTO> films = new ArrayList<>();
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.FIND_ALL_FILMS_THIS_AND_LAST_YEARS.QUERY);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                FilmDTO film = new FilmDTO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4));
                films.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return films;
    }

    public boolean deleteFilmsMoreThanNYearsAgo(int nYears) {
        boolean result = false;
        Calendar calendar = new GregorianCalendar(2022 - nYears, Calendar.JANUARY, 1);
        String date = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLFilm.DELETE_FILMS_MORE_THAN_N_YEARS_AGO.QUERY);
            pst.setString(1,date);
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    enum SQLFilm {
        CREATE_FILM("INSERT INTO FILMS VALUE ((?), (?), (?), (?))"),
        FIND_ALL_FILMS("SELECT * FROM films"),
        FIND_FILM_By_ID("SELECT * FROM films WHERE Id = (?)"),
        UPDATE("UPDATE films SET Film_Name = (?), Date_Prodaction = (?), Country = (?) WHERE i = (?) "),
        DELETE_FILM("DELETE FROM films WHERE Id = (?) AND film_name = (?) AND date_prodaction = (?) AND country = (?)"),
        DELETE_BY_ID("DELETE FROM films WHERE id = (?)"),
        FIND_ALL_FILMS_THIS_AND_LAST_YEARS("SELECT * FROM films WHERE DATE(date_prodaction) > '2021-01-01'"),
        DELETE_FILMS_MORE_THAN_N_YEARS_AGO("DELETE f,fa,fd FROM films f JOIN film_actors fa ON f.id = fa.film__id " +
                "JOIN film_directors fd ON f.id = fd.film_id " +
                "WHERE DATE(date_prodaction) < (?)");


        String QUERY;

        SQLFilm(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
