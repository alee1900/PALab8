package Tables;

import lombok.Data;

/**
 * Class Directors, for DB Directors
 */
@Data
public class Directors {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
