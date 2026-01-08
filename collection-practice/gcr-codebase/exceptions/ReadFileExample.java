import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {

    public static void main(String[] args) {

        // File name to read
        String fileName = "data.txt";

        // try block for risky code (file handling causes checked exception)
        try {
            // FileReader reads characters from file
            FileReader fr = new FileReader(fileName);

            // BufferedReader for efficient line-by-line reading
            BufferedReader br = new BufferedReader(fr);

            String line;

            // Read file until end (null)
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            // Close resources
            br.close();
            fr.close();
        }

        // catch block for handling IOException
        catch (IOException e) {
            // User-friendly message
            System.out.println("File not found");
        }
    }
}
