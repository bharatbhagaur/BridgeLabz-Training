package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSV {

    public static void main(String[] args) {

        String inputFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\newemployees.csv";           // Original file
        String outputFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\updated_newemployees.csv"; // New updated file
        String line;

        try {
            // Reader to read CSV file
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            // Writer to write new CSV file
            FileWriter writer = new FileWriter(outputFile);

            // Read header and write it to new file
            String header = br.readLine();
            writer.write(header + "\n");

            // Read remaining records
            while ((line = br.readLine()) != null) {

                // Split line by comma
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                // If department is IT, increase salary by 10%
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                }

                // Write updated record to new CSV file
                writer.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            // Close resources
            br.close();
            fr.close();
            writer.close();

            System.out.println("Salary updated successfully! ✅");
            System.out.println("New file created: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
