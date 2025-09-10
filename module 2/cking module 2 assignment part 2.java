//cking module 2 assignment part 2
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public static void main(String[] args) {
        String filename = "cking datafile.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contents of " + filename + ":\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

