package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\count.csv";   // CSV file path
        String line;
        int count = 0;                      // Record counter

        try {
            // Open file for reading
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            // Read and skip header line
            br.readLine();

            // Read remaining lines (data rows)
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {   // Ignore empty lines
                    count++;
                }
            }

            // Close file
            br.close();
            fr.close();

            // Print total record count
            System.out.println("Total Records (excluding header): " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
