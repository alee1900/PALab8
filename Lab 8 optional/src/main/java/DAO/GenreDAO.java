package DAO;

import Tables.Genres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DBConnection.getConnection;

/**
 * Class GenreDAO
 * Offers methods for creating and finding genres in DB
 */
public class GenreDAO {
    static Connection connection = getConnection();

    /**
     * Method for adding a genre into the DB
     * @param genre represents the genre to be added
     * @return the result of the query
     * @throws SQLException if there is a problem accessing the DB
     */
    public int add(Genres genre) throws SQLException {
        String query = "insert into genres(id, name)" +
                "values (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, genre.getId());
        ps.setString(2, genre.getName());
        return ps.executeUpdate();
    }

    /**
     * Method for deleting a genre from the DB
     * @param id represents the id of the genre to be deleted
     * @throws SQLException if there is a problem accessing the DB
     */
    public void delete(int id) throws SQLException {
        String query = "delete from genres where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    /**
     * Method for searching a genre by their id
     * @param id represents the id to search for
     * @return the genre, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Genres getById(int id) throws SQLException {
        String query = "select * from genres where ID=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        Genres genre = new Genres();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            genre.setId(resultSet.getInt("id"));
            genre.setName(resultSet.getString("name"));
        }

        if (check) {
            return genre;
        } else
            return null;
    }

    /**
     * Method for searching a genre by their name
     * @param name represents the name to search for
     * @return the genre, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Genres getByName(String name) throws SQLException {
        String query = "select * from genres where name=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        Genres genre = new Genres();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            genre.setId(resultSet.getInt("id"));
            genre.setName(resultSet.getString("name"));
        }

        if (check) {
            return genre;
        } else
            return null;
    }

    /**
     * Method to get a list of all genres in the DB
     * @return the list of genres
     * @throws SQLException if there is a problem accessing the DB
     */
    public List<Genres> getGenres() throws SQLException {
        String query = "select * from genres";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        List<Genres> list = new ArrayList<>();

        while (resultSet.next()) {
            Genres genre = new Genres();
            genre.setId(resultSet.getInt("id"));
            genre.setName(resultSet.getString("name"));
            list.add(genre);
        }
        return list;
    }
}
