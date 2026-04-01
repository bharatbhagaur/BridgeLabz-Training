import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;

public class LargeFileReadingComparison {

    public static void main(String[] args) {

        // Change this path to a large file (100MB / 500MB)
        String filePath = "largefile.txt";

        // -------- FileReader Test --------
        long startFileReader = System.nanoTime();
        readUsingFileReader(filePath);
        long endFileReader = System.nanoTime();

        long fileReaderTime = endFileReader - startFileReader;

        // -------- InputStreamReader Test --------
        long startInputStreamReader = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long endInputStreamReader = System.nanoTime();

        long inputStreamReaderTime = endInputStreamReader - startInputStreamReader;

        // -------- Results --------
        System.out.println("File Reading Performance Comparison:");
        System.out.println("FileReader Time        : " + fileReaderTime / 1_000_000 + " ms");
        System.out.println("InputStreamReader Time : " + inputStreamReaderTime / 1_000_000 + " ms");
    }

    // Reading file using FileReader (Character Stream)
    static void readUsingFileReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while (reader.readLine() != null) {
                // Reading file line by line
            }

        } catch (IOException e) {
            System.out.println("Error reading file using FileReader: " + e.getMessage());
        }
    }

    // Reading file using InputStreamReader (Byte Stream → Character Stream)
    static void readUsingInputStreamReader(String filePath) {
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {

            while (reader.readLine() != null) {
                // Reading file line by line
            }

        } catch (IOException e) {
            System.out.println("Error reading file using InputStreamReader: " + e.getMessage());
        }
    }
}

