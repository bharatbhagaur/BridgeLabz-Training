package functionalinterface;

public class BackgroundJobExecutor {

    public static void main(String[] args) {

        // Runnable functional interface using lambda expression
        Runnable backgroundTask = () -> {

            System.out.println("Background task started");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }

            System.out.println("Background task completed");
        };

        // Creating and starting a new thread
        Thread workerThread = new Thread(backgroundTask);
        workerThread.start();

        System.out.println("Main thread continues execution");
    }
}
