package DAO;

import Tables.Movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DBConnection.getConnection;

/**
 * Class MovieDAO
 * Offers methods for creating and finding movies in DB
 */
public class MovieDAO {
    static Connection connection = getConnection();

    /**
     * Method for adding a movie into the DB
     * @param movie represents the movie to be added
     * @return the result of the query
     * @throws SQLException if there is a problem accessing the DB
     */
    public int add(Movies movie) throws SQLException {
        String query = "insert into movies(id, title," +
                "release_date, duration, score)" +
                "values (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, movie.getId());
        ps.setString(2, movie.getTitle());
        ps.setString(3, movie.getRelease_date());
        ps.setInt(4, movie.getDuration());
        ps.setInt(5, movie.getScore());
        return ps.executeUpdate();
    }

    /**
     * Method for deleting a movie from the DB
     * @param id represents the id of the movie to be deleted
     * @throws SQLException if there is a problem accessing the DB
     */
    public void delete(int id) throws SQLException {
        String query = "delete from movies where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    /**
     * Method for searching a movie by their id
     * @param id represents the id to search for
     * @return the movie, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Movies getById(int id) throws SQLException {
        String query = "select * from movies where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        Movies movie = new Movies();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setRelease_date(resultSet.getString("release_date"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setScore(resultSet.getInt("score"));
        }
        if (check) {
            return movie;
        } else
            return null;
    }

    /**
     * Method for searching a movie by their name
     * @param name represents the name to search for
     * @return the movie, if found, null otherwise
     * @throws SQLException if there is a problem accessing the DB
     */
    public Movies getByName(String name) throws SQLException {
        String query = "select * from movies where title=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        Movies movie = new Movies();
        ResultSet resultSet = ps.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setRelease_date(resultSet.getString("release_date"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setScore(resultSet.getInt("score"));
        }
        if (check) {
            return movie;
        } else
            return null;
    }

    /**
     * Method to get a list of all movies in the DB
     * @return the list of movies
     * @throws SQLException if there is a problem accessing the DB
     */
    public List<Movies> getMovies() throws SQLException {
        String query = "select * from movies";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        List<Movies> list = new ArrayList<>();

        while (resultSet.next()) {
            Movies movie = new Movies();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setRelease_date(resultSet.getString("release_date"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setScore(resultSet.getInt("score"));
            list.add(movie);
        }
        return list;
    }
}
