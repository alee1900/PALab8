package DAO;

import Tables.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBConnection.getConnection;

public class Movie {
    static Connection connection = getConnection();

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

    public void delete(int id) throws SQLException {
        String query = "delete from movies where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

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
