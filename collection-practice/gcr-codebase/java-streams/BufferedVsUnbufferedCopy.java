package javastream;

import java.io.*;

public class BufferedVsUnbufferedCopy {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {

        String sourceFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\source.txt";          // put 100MB file in project
        String normalCopy = "C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\normal_copy.txt";
        String bufferedCopy ="C:\\Users\\USER\\Desktop\\New folder (3)\\practicejava\\src\\javastream\\buffered_copy.txt";

        copyUsingNormalStreams(sourceFile, normalCopy);
        copyUsingBufferedStreams(sourceFile, bufferedCopy);
    }

    // ---------------- NORMAL STREAMS ----------------
    static void copyUsingNormalStreams(String src, String dest) {

        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Normal Stream Error: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        System.out.println("Normal Stream Time (ns): " + timeTaken);
    }

    // ---------------- BUFFERED STREAMS ----------------
    static void copyUsingBufferedStreams(String src, String dest) {

        long startTime = System.nanoTime();

        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered Stream Error: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        System.out.println("Buffered Stream Time (ns): " + timeTaken);
    }
}

