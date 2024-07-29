package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MultiThreadedRemoval {

    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<Integer>();
        // Add some IDs to the list
        for (int i = 1; i <= 1000; i++) {
            ids.add(i);
        }

        System.out.println();
        long starttime = System.currentTimeMillis();

        // Create a thread pool with a fixed number of threads
        int numberOfThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Iterate over the list and submit tasks to the executor
        for (final Integer id : ids) {
            executor.submit(new Runnable() {
                public void run() {
                    removeItemById(id, Thread.currentThread().getId());
                }
            });
        }

        // Shut down the executor service gracefully
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait until all tasks are finished
        }

        long totaltime = System.currentTimeMillis() - starttime;
        System.out.println("All tasks completed - " + totaltime);
    }

    // Example method to remove item by ID
    public static void removeItemById(Integer id, long threadId) {
        // Simulate some work with a print statement and sleep
        System.out.println("Removing item with ID: " + id + " - ThreadId " + threadId);
        try {
            Thread.sleep(100); // Simulate some work with sleep
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

