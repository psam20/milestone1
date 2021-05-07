import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {
    public static final String delimiter = ",";

    public void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            Map<String, List<String>> map1 = new HashMap<String, List<String>>();
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) {

                tempArr = line.split(delimiter);

                for(String tempStr : tempArr) {
                    System.out.println("TEMP Arr----->  "+tempStr);
                    System.out.println();
                }
                System.out.println();
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
