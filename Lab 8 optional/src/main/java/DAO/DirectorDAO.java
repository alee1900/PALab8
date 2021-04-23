package DAO;

import Tables.Directors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DBConnection.getConnection;

/**
 * Class DirectorDAO
 * Offers methods for creating and finding directors in DB
 */
public class DirectorDAO {
    static Connection connection = getConnection();

    /**
     * Method for adding a director into the DB
     * @param director represents the director to be added
     * @return the result of the query
     * @throws SQLException if there is a problem accessing the DB
     */
    public int add(Directors director) throws SQLException {
        String query = "insert into directors(id, name)" +
                "values (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, director.getId());
        ps.setString(2, director.getName());
        return ps.executeUpdate();
    }

    /**
     * Method for deleting a director from the DB
     * @param id represents the id of the director to be deleted
     * @throws SQLException if there is a problem accessing the DB
     */
    public void delete(int id) throws SQLException {
        String query = "delete from directors where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    /**
     * Method for searching a director by their id
     * @param id represents the id to search for
     * @return the director, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Directors getById(int id) throws SQLException {
        String query = "select * from directors where ID=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        Directors director = new Directors();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            director.setId(resultSet.getInt("id"));
            director.setName(resultSet.getString("name"));
        }

        if (check) {
            return director;
        } else
            return null;
    }

    /**
     * Method for searching a director by their name
     * @param name represents the name to search for
     * @return the director, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Directors getByName(String name) throws SQLException {
        String query = "select * from directors where name=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        Directors director = new Directors();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            director.setId(resultSet.getInt("id"));
            director.setName(resultSet.getString("name"));
        }

        if (check) {
            return director;
        } else
            return null;
    }

    /**
     * Method to get a list of all directors in the DB
     * @return the list of directors
     * @throws SQLException if there is a problem accessing the DB
     */
    public List<Directors> getDirectors() throws SQLException {
        String query = "select * from directors";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        List<Directors> list = new ArrayList<>();

        while (resultSet.next()) {
            Directors director = new Directors();
            director.setId(resultSet.getInt("id"));
            director.setName(resultSet.getString("name"));
            list.add(director);
        }
        return list;
    }
}
