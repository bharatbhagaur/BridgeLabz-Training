package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\read.csv";   // CSV file path
        String line;                        // Store each line

        try {
            // FileReader reads the file
            FileReader fr = new FileReader(filePath);

            // BufferedReader reads line by line
            BufferedReader br = new BufferedReader(fr);

            // Skip header line
            br.readLine();

            // Read file until last line
            while ((line = br.readLine()) != null) {

                // Split line by comma
                String[] data = line.split(",");

                // Store values
                String id = data[0];
                String name = data[1];
                String age = data[2];
                String marks = data[3];

                // Print in structured format
                System.out.println("ID    : " + id);
                System.out.println("Name  : " + name);
                System.out.println("Age   : " + age);
                System.out.println("Marks : " + marks);
                System.out.println("----------------------");
            }

            // Close resources
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
