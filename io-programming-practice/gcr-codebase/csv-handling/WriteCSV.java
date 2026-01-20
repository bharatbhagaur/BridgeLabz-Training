package csvhandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\write.csv";   // CSV file name

        try {
            // FileWriter creates or overwrites the file
            FileWriter writer = new FileWriter(filePath);

            // Write header
            writer.write("ID,Name,Department,Salary\n");

            // Write employee records
            writer.write("1,Rahul,IT,55000\n");
            writer.write("2,Aman,HR,48000\n");
            writer.write("3,Priya,Finance,60000\n");
            writer.write("4,Neha,Marketing,52000\n");
            writer.write("5,Rohit,Sales,50000\n");

            // Close file
            writer.close();

            System.out.println("CSV file created and data written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
