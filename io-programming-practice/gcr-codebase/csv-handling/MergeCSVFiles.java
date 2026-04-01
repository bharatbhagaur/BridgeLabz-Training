package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class MergeCSVFiles {

    public static void main(String[] args) {

        String file1 = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\student1.csv";
        String file2 = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\student2.csv";
        String outputFile = "merged_students.csv";

        // Map to store students1 data (ID -> Name,Age)
        HashMap<String, String> studentMap = new HashMap<>();

        String line;

        try {
            // ---------- Read students1.csv ----------
            BufferedReader br1 = new BufferedReader(new FileReader(file1));

            // Skip header
            br1.readLine();

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String age = data[2];

                // Store in map
                studentMap.put(id, name + "," + age);
            }
            br1.close();

            // ---------- Prepare writer for merged file ----------
            FileWriter writer = new FileWriter(outputFile);

            // Write header
            writer.write("ID,Name,Age,Marks,Grade\n");

            // ---------- Read students2.csv ----------
            BufferedReader br2 = new BufferedReader(new FileReader(file2));

            // Skip header
            br2.readLine();

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String marks = data[1];
                String grade = data[2];

                // Check if ID exists in first file
                if (studentMap.containsKey(id)) {

                    String nameAge = studentMap.get(id);

                    // Write merged record
                    writer.write(id + "," + nameAge + "," + marks + "," + grade + "\n");
                }
            }

            br2.close();
            writer.close();

            System.out.println("CSV files merged successfully! ✅");
            System.out.println("New file created: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing CSV files: " + e.getMessage());
        }
    }
}
