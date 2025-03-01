import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class producer_consumer {
    private static final int BUFFER_SIZE = 50; // Maximum buffer size
    private static final BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(BUFFER_SIZE);
    private static volatile boolean stopExecution = false; // Flag to stop execution
    private static final Random random = new Random();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (!stopExecution) {
                try {
                    int item = random.nextInt(100); // Generate a random integer (0-99)
                    if (buffer.remainingCapacity() == 0) {
                        System.out.println("Fuckit, we don't have enough space...");
                        stopExecution = true;
                        break;
                    }
                    buffer.put(item);
                    System.out.println("Produced: " + item);
                    Thread.sleep(random.nextInt(500) + 500); // Random delay (500-1000ms)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (!stopExecution) {
                try {
                    int removeCount = random.nextInt(3) + 1; // Randomly remove 1-3 items
                    if (buffer.size() < removeCount) {
                        System.out.println("FUCCKK....We ran out of space.");
                        stopExecution = true;
                        break;
                    }
                    for (int i = 0; i < removeCount; i++) {
                        int consumedItem = buffer.take();
                        System.out.println("Consumed: " + consumedItem);
                    }
                    Thread.sleep(random.nextInt(800) + 500); // Random delay (500-1300ms)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
