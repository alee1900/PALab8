package Tables;

import lombok.Data;

/**
 * Class Movies, for DB Movies
 */
@Data
public class Movies {
    private int id;
    private String title;
    private String release_date;
    private int duration;
    private int score;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", release_date='" + release_date + '\'' +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
