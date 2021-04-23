package Tables;

import lombok.Data;

/**
 * Class Actors, for DB Actors
 */
@Data
public class Actors {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
