package javastream;

import java.io.*;

public class UpperToLowerFileCopy {

    public static void main(String[] args) {

        String sourceFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\source.txt";   ;
        String destinationFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\copy.txt";

        // Try-with-resources auto closes all streams
        try (
            // FileReader + BufferedReader for efficient reading
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(sourceFile), "UTF-8"));

            // FileWriter + BufferedWriter for efficient writing
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8"));
        ) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Convert entire line to lowercase
                String lowerLine = line.toLowerCase();

                // Write to output file
                bw.write(lowerLine);
                bw.newLine(); // keep line breaks
            }

            System.out.println("File copied with lowercase conversion successfully!");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}

