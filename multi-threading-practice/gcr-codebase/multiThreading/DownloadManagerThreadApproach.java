package multiThreading;

import java.util.Random;

class FileDownloaderThread extends Thread {

    private String fileName;
    private Random random = new Random();

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading "
                    + fileName + ": " + progress + "%");

            try {
                // random delay to simulate download time
                Thread.sleep(200 + random.nextInt(400)); // 200ms to 600ms
            } catch (InterruptedException e) {
                System.out.println(fileName + " download interrupted");
            }
        }
    }
}

public class DownloadManagerThreadApproach {

    public static void main(String[] args) throws InterruptedException {

        FileDownloaderThread t1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 = new FileDownloaderThread("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        // Main thread waits for all downloads to complete
        t1.join();
        t2.join();
        t3.join();

        System.out.println("\nAll downloads complete!");
    }
}
