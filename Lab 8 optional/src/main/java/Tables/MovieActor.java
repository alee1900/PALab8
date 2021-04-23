package Tables;

import lombok.Data;

/**
 * Class MovieActor, for DB movie_actor
 */
@Data
public class MovieActor {
    private int id_movie;
    private int id_actor;

    @Override
    public String toString() {
        return "MovieActor{" +
                "id_movie=" + id_movie +
                ", id_actor=" + id_actor +
                '}';
    }
}
