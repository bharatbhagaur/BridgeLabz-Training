package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeCSV {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\USER\\Desktop\\New folder (3)\\ioprogramming\\src\\csvhandling\\employees.csv";   // CSV file path
        String line;
        boolean found = false;

        Scanner sc = new Scanner(System.in);

        // Take employee name input
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine();

        try {
            // Open file for reading
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            // Skip header line
            br.readLine();

            // Read each record
            while ((line = br.readLine()) != null) {

                // Split line by comma
                String[] data = line.split(",");

                String name = data[1];
                String department = data[2];
                String salary = data[3];

                // Compare names (ignore case)
                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("\nEmployee Found ✅");
                    System.out.println("Name       : " + name);
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : " + salary);
                    found = true;
                    break;   // Stop after finding
                }
            }

            // Close resources
            br.close();
            fr.close();
            sc.close();

            // If not found
            if (!found) {
                System.out.println("\nEmployee not found ❌");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
