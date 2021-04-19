import DAO.Genre;
import DAO.Movie;
import Tables.Genres;
import Tables.Movies;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Movies movie = new Movies();
        Genres genreComedy = new Genres();

        movie.setId(1);
        movie.setTitle("Miami Bici");
        movie.setRelease_date("21/02/2020");
        movie.setDuration(98);
        movie.setScore(6);

        genreComedy.setId(1);
        genreComedy.setName("Comedy");

        Genre genreDAO = new Genre();
        Movie movieDAO = new Movie();

        movieDAO.add(movie);

        Movies movie1 = movieDAO.getById(1);
        System.out.println(movie1);

        genreDAO.add(genreComedy);

        Genres genre = genreDAO.getById(1);
        System.out.println(genre);
    }
}
