//cking module 2 assignment
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataWriter {
    public static void main(String[] args) {
        String filename = "cking datafile.dat";
        Random rand = new Random();

        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100); // integers between 0–99
            doubleArray[i] = rand.nextDouble() * 100; // doubles between 0.0–99.99
        }

        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Integers: ");
            for (int num : intArray) {
                writer.write(num + " ");
            }
            writer.write("\nDoubles: ");
            for (double val : doubleArray) {
                writer.write(String.format("%.2f ", val));
            }
            writer.write("\n---\n");
            System.out.println("Data successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

