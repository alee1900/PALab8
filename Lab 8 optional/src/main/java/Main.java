import DAO.GenreDAO;
import DAO.MovieDAO;
import Tables.Genres;
import Tables.Movies;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        Movies movie = new Movies();
        Genres genreComedy = new Genres();

        movie.setId(1);
        movie.setTitle("Miami Bici");
        movie.setRelease_date("21/02/2020");
        movie.setDuration(98);
        movie.setScore(6);

        genreComedy.setId(1);
        genreComedy.setName("Comedy");

        GenreDAO genreDAO = new GenreDAO();
        MovieDAO movieDAO = new MovieDAO();

        movieDAO.add(movie);

        Movies movie1 = movieDAO.getById(1);
        System.out.println(movie1);

        genreDAO.add(genreComedy);

        Genres genre = genreDAO.getById(1);
        System.out.println(genre);

        ImportData importData = new ImportData();
    }
}
