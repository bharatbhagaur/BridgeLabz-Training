import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadInputAndWriteToFile {

    public static void main(String[] args) {

        // File name where input will be stored
        String fileName = "user_input.txt";

        try {
            // Read input from console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(isr);

            // Write input to file
            FileWriter writer = new FileWriter(fileName, true);

            System.out.println("Enter text (type 'exit' to stop):");

            String input;

            // Read input until user types "exit"
            while (true) {
                input = reader.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Write input to file with new line
                writer.write(input + System.lineSeparator());
            }

            // Close resources
            reader.close();
            writer.close();

            System.out.println("Input successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
