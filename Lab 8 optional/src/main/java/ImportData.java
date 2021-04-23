import DAO.MovieDAO;
import Tables.Movies;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class ImportData, used to import data from dataset
 */
public class ImportData {
    public ImportData() throws IOException, ParseException, SQLException {
        CSVReader reader = new CSVReader(new FileReader("G:\\Facultate\\Anul II - Sem II\\Java\\Lab 8 all\\Lab 8 optional\\IMDb movies.csv"));

        //read line by line
        String[] nextLine;
        StringBuilder result = new StringBuilder();
        int lineNumber = 0;
        if ((nextLine = reader.readNext()) != null) {
            lineNumber++;
        }

        Movies movie = new Movies();
        MovieDAO movieDao = new MovieDAO();

        int id = 3;
        while (((nextLine = reader.readNext()) != null) && lineNumber < 8) {
            System.out.println("Line # " + lineNumber);
            movie.setId(id++);
            movie.setTitle(nextLine[1]);
            movie.setRelease_date(nextLine[3]);
            DateFormat formatter = new SimpleDateFormat("HH:mm");
            movie.setDuration(Integer.parseInt(nextLine[6]));
            movie.setScore((int) Float.parseFloat(nextLine[14]));
            movieDao.add(movie);
            System.out.println(movie);
            lineNumber++;

        }
        reader.close();
    }
}
