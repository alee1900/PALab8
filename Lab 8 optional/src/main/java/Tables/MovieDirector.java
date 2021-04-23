package Tables;

import lombok.Data;

/**
 * Class MovieDirector, for DB movie_director
 */
@Data
public class MovieDirector {
    private int id_movie;
    private int id_director;

    @Override
    public String toString() {
        return "MovieDirector{" +
                "id_movie=" + id_movie +
                ", id_director=" + id_director +
                '}';
    }
}
