package advanced.java.ua.univer.practice8.DAO_Level;

import advanced.java.ua.univer.practice7.subject_area.Actor;
import advanced.java.ua.univer.practice8.ConnectionPool;
import advanced.java.ua.univer.practice8.DOT_Level.ActorDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO implements DAO<ActorDTO, Integer> {
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
    public boolean create(ActorDTO actor) {
        boolean result = false;
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLActor.CREATE_ACTOR.QUERY);
            pst.setInt(1, actor.getId());
            pst.setString(2, actor.getFullName());
            pst.setDate(3, (Date) actor.getBirthdate());
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public List<ActorDTO> findAll() {
        List<ActorDTO> actors = new ArrayList<>();
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLActor.GET_ALL.QUERY);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ActorDTO actor = new ActorDTO(rs.getInt("Id"), rs.getString("FIO"), rs.getDate("Birthdate"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return actors;
    }

    @Override
    public ActorDTO findEntityById(Integer id) {
        ActorDTO actor = new ActorDTO(-1, null, null);
        Connection connection =  cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLActor.GET_BY_ID.QUERY);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                actor = new ActorDTO(rs.getInt("Id"), rs.getString("FIO"), rs.getDate("Birthdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return actor;
    }

    @Override
    public boolean update(ActorDTO actor) {
        boolean result = false;
        Connection connection = cn.getConnection();
        try {
            pst = connection.prepareStatement(SQLActor.UPDATE.QUERY);
            pst.setString(1, actor.getFullName());
            pst.setDate(2, (Date) actor.getBirthdate());
            pst.setInt(3, actor.getId());
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
        Connection connection =  cn.getConnection();
        try{
            pst = connection.prepareStatement(SQLActor.DELETE_BY_ID.QUERY);
            pst.setInt(1,id);
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public boolean delete(ActorDTO actor) {
        boolean result = false;
        Connection connection = cn.getConnection();
        try{
            pst = connection.prepareStatement(SQLActor.DELETE_BY_ID.QUERY);
            pst.setInt(1,actor.getId());
            pst.setString(2,actor.getFullName());
            pst.setDate(3,(Date)actor.getBirthdate());
            result = pst.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return result;
    }

    public List<Actor> actorsIsDirectors(){
        List<Actor> actors = new ArrayList<>();
        Connection connection = cn.getConnection();
        try{
            pst = connection.prepareStatement(SQLActor.ACTORS_IS_DIRECTOR.QUERY);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              Actor actor = new Actor(rs.getInt("Id"),rs.getString("FIO"), rs.getDate("Birthdate"));
              actors.add(actor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            cn.releaseConnection(connection);
        }
        return actors;
    }

    public List<ActorDTO> actorsInFilmsNTimes(int times){
        List<ActorDTO> actors = new ArrayList<>();
        Connection connection = cn.getConnection();
        try{
            pst = connection.prepareStatement(SQLActor.ACTORS_IN_FILMS_N_TIMES.QUERY);
            pst.setInt(1,times);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ActorDTO actor = new ActorDTO(rs.getInt("Id"), rs.getString("FIO"), rs.getDate("Birthdate"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actors;
    }

    public List<ActorDTO> actorsInSpecifiedFilm(String filmName){
        List<ActorDTO> actors = new ArrayList<>();
        Connection connection = cn.getConnection();
        try{
            pst = connection.prepareStatement(SQLActor.ACTORS_IN_SPECIFIED_FILM.QUERY);
            pst.setString(1,filmName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                ActorDTO actor = new ActorDTO(rs.getInt(1), rs.getString(2),rs.getDate(3));
                actors.add(actor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cn.releaseConnection(connection);
        }
        return actors;
    }

    enum SQLActor {
        CREATE_ACTOR("INSERT INTO actors VALUE ( (?) ,(?) ,(?) )"),
        GET_ALL("SELECT * FROM actors"),
        GET_BY_ID("SELECT * FROM actors WHERE Id=(?)"),
        UPDATE("UPDATE actors SET fio = (?), birthdate = (?) WHERE id = (?)"),
        DELETE_BY_ID("DELETE FROM actors WHERE Id = (?)"),
        DELETE_ACTOR("DELETE FROM actors WHERE Id = (?) AND FIO = (?) AND Birthday = (?)"),
        ACTORS_IS_DIRECTOR("SELECT * FROM actors JOIN film_directors fd ON actors.Id = fd.Actor_Id " +
                                "JOIN films ON fd.Film_ID = films.Id "),
        ACTORS_IN_FILMS_N_TIMES("SELECT Id, FIO, Birthdate, COUNT(Film__id) Film_amount FROM film_actors " +
                "JOIN actors ON Actor_id = id " +
                "GROUP BY Id " +
                "HAVING Film_amount >= (?)"),
        ACTORS_IN_SPECIFIED_FILM("SELECT actors.Id,FIO,Birthdate FROM actors JOIN film_actors fa ON actors.Id = fa.Actor_Id " +
                "JOIN films f ON fa.Film__Id = f.Id WHERE Film_Name = (?)");

        String QUERY;

        SQLActor(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
