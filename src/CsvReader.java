import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CsvReader {
    public static final String delimiter = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    public static List<Netflix> read(String csvFile) throws IOException, ParseException {
        BufferedReader csvReader;
        List<Netflix> MovieList = new ArrayList<>();


        String line;
        csvReader = new BufferedReader(new FileReader(csvFile));
        int count = 0;
        //Read the file line by line
        while ((line = csvReader.readLine()) != null) {
            //Get all Items available in the line
            line.trim();
            String[] listArr = line.split(delimiter);
            if(count == 0)
            {
                count++;
                continue;
            }
            String show_id = listArr[0];
            String type = listArr[1];
            String title = listArr[2];
            Set<String> director = new HashSet<>(Arrays.asList(listArr[3].split(",")));
            Set<String> cast = new HashSet<>(Arrays.asList(listArr[4].split(",")));
            Set<String> country = new HashSet<>(Arrays.asList(listArr[5].split(",")));
            String release_year = listArr[7];
            String rating = listArr[8];
            String duration = listArr[9];
            Set<String> listed_in = new HashSet<>(Arrays.asList(listArr[10].split(",")));
            String description = listArr[11];
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date;
            date = !listArr[6].isEmpty() ? format.parse(listArr[6].replaceAll("\"","").trim()) : null;

            Netflix movie = new Netflix(show_id, type, title, director, cast, country,
                    date,release_year,rating, duration, listed_in,description);
            MovieList.add(movie);


        }
        return MovieList;
    }
}
