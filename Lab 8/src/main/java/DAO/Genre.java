package DAO;

import Tables.Genres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBConnection.getConnection;

public class Genre {
    static Connection connection = getConnection();

    public int add(Genres genre) throws SQLException {
        String query = "insert into genres(id, name)" +
                "values (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, genre.getId());
        ps.setString(2, genre.getName());
        return ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = "delete from genres where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

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
