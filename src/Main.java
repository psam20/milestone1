public class Main {
    public static void main(String[] args) {
        String fileName="//home//kishan//Downloads//netflix_titles.csv";
        CsvReader newFile = new CsvReader();
        newFile.read(fileName);
    }
}
