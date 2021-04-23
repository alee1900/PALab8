package Tables;

import lombok.Data;

/**
 * Class MovieGenre, for DB movie_genre
 */
@Data
public class MovieGenre {
    private int id_movie;
    private int id_genre;

    @Override
    public String toString() {
        return "MovieGenre{" +
                "id_movie=" + id_movie +
                ", id_genre=" + id_genre +
                '}';
    }
}
