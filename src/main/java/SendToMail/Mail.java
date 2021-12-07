package SendToMail;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Mail {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(5);
        Runnable runnable = () -> {
            while (true) {
                try {
                    System.out.println(blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable1 = () -> {
            while (true) {
                blockingQueue.add(new Scanner(System.in).nextLine());
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(runnable);
        executorService.execute(runnable1);
        executorService.shutdown();
    }
}
