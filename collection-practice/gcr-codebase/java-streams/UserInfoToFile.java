

import java.io.*; // Import all IO classes

public class UserInfoToFile {

    public static void main(String[] args) {

        // BufferedReader is used to take input from console (keyboard)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // FileWriter object to write data into file
        FileWriter fw = null;

        try {
            // Asking user for name
            System.out.print("Enter your name: ");
            String name = br.readLine(); // read full line

            // Asking user for age
            System.out.print("Enter your age: ");
            String age = br.readLine();

            // Asking user for favorite programming language
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Creating FileWriter (file will be created if not exists)
            fw = new FileWriter("C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\user_info.txt");

            // Writing data into file
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            // Success message
            System.out.println("Data saved successfully into user_info.txt");

        }
        // Catch block to handle input/output errors
        catch (IOException e) {
            System.out.println("Error while reading input or writing to file.");
            System.out.println(e.getMessage());
        }
        // Finally block to close resources
        finally {
            try {
                // Closing FileWriter if opened
                if (fw != null)
                    fw.close();

                // Closing BufferedReader
                if (br != null)
                    br.close();

            } catch (IOException e) {
                System.out.println("Error while closing resources.");
            }
        }
    }
}
