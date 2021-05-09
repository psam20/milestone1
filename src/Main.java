import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String fileName="//home//kishan//Desktop//Milestone Assignment1//src//netflix_titles.csv";
        List<Netflix> movies =  CsvReader.read(fileName);
        Scanner sc =  new Scanner(System.in);
        System.out.println("Please Enter number of movies to list out");
        int n = sc.nextInt();
        System.out.println("Please Enter start date in dd-mm-yyyy format");
        String sDate = sc.next();
        Date startDate = !sDate.equals("") ? new SimpleDateFormat("dd-MM-yyyy").parse(sDate) : null;
        System.out.println("Please Enter end date in dd-mm-yyyy format");
        String eDate = sc.next();
        Date endDate = !sDate.equals("") ? new SimpleDateFormat("dd-MM-yyyy").parse(eDate) : null;

        System.out.println("Please Enter 1 to Search for TV Show");
        System.out.println("Please Enter 2 to Search for Horror Movies");
        System.out.println("Please Enter 3 to Search for Indian Movies");

        int userInput = sc.nextInt();
        if(userInput == 1)
            FilterNetflixData.filterByTypeTvShow(movies, n, startDate, endDate);
        else if(userInput == 2)
            FilterNetflixData.findListedHorrorMovie(movies, n, startDate, endDate);
        else if(userInput == 3)
            FilterNetflixData.filterIndianMovie(movies, n, startDate, endDate);
        else
            System.out.println("Please Enter valid option to see the results");
    }
}
