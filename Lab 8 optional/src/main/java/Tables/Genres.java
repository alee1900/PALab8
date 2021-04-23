package Tables;

import lombok.Data;

/**
 * Class Genres, for DB Genres
 */
@Data
public class Genres {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
