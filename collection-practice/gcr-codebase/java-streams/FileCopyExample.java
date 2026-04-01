

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {

    public static void main(String[] args) {

        String sourceFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\source.txt";      // file to read from
        String destinationFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\copy.txt";   // file to write into

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // open source file
            fis = new FileInputStream(sourceFile);

            // create destination file (auto creates if not exists)
            fos = new FileOutputStream(destinationFile);

            int data;

            // read byte by byte and write
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: Source file not found or IO problem!");
            System.out.println(e.getMessage());

        } finally {
            // closing resources
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing file.");
            }
        }
    }
}
