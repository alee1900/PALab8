package DAO;

import Tables.Actors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class ActorDAO
 * Offers methods for creating and finding actors in DB
 */
public class ActorDAO {
    static Connection connection = DBConnection.getConnection();

    /**
     * Method for adding an actor into the DB
     * @param actor represents the actor to be added
     * @return the result of the query
     * @throws SQLException if there is a problem accessing the DB
     */
    public int add(Actors actor) throws SQLException {
        String query = "insert into actors(id, name)" +
                "values (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, actor.getId());
        ps.setString(2, actor.getName());
        return ps.executeUpdate();
    }

    /**
     * Method for deleting an actor from the DB
     * @param id represents the id of the actor to be deleted
     * @throws SQLException if there is a problem accessing the DB
     */
    public void delete(int id) throws SQLException {
        String query = "delete from actors where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    /**
     * Method for searching an actor by their id
     * @param id represents the id to search for
     * @return the actor, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Actors getById(int id) throws SQLException {
        String query = "select * from actors where ID=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        Actors actor = new Actors();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            actor.setId(resultSet.getInt("id"));
            actor.setName(resultSet.getString("name"));
        }

        if (check) {
            return actor;
        } else
            return null;
    }

    /**
     * Method for searching an actor by their name
     * @param name represents the name to search for
     * @return the actor, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Actors getByName(String name) throws SQLException {
        String query = "select * from actors where name=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        Actors actor = new Actors();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            actor.setId(resultSet.getInt("id"));
            actor.setName(resultSet.getString("name"));
        }

        if (check) {
            return actor;
        } else
            return null;
    }

    /**
     * Method to get a list of all actors in the DB
     * @return the list of actors
     * @throws SQLException if there is a problem accessing the DB
     */
    public List<Actors> getActors() throws SQLException {
        String query = "select * from actors";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        List<Actors> list = new ArrayList<>();

        while (resultSet.next()) {
            Actors actor = new Actors();
            actor.setId(resultSet.getInt("id"));
            actor.setName(resultSet.getString("name"));
            list.add(actor);
        }
        return list;
    }
}
