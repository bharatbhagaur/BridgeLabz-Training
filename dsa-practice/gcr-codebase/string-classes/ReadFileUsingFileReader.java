import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileUsingFileReader {

    public static void main(String[] args) {

        // File path (change this path as per your system)
        String filePath = "sample.txt";

        try {
            // Create FileReader to read the file
            FileReader fileReader = new FileReader(filePath);

            // Wrap FileReader with BufferedReader for line-by-line reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the resources
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
