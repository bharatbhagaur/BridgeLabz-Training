package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterStudentsCSV {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\student.csv";  ;   // CSV file path
        String line;

        try {
            // Open file for reading
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            // Skip header line
            br.readLine();

            System.out.println("Students scoring more than 80 marks:\n");

            // Read each data row
            while ((line = br.readLine()) != null) {

                // Split line by comma
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                // Filter condition
                if (marks > 80) {
                    // Print qualifying records
                    System.out.println("ID    : " + id);
                    System.out.println("Name  : " + name);
                    System.out.println("Age   : " + age);
                    System.out.println("Marks : " + marks);
                    System.out.println("---------------------");
                }
            }

            // Close file
            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
