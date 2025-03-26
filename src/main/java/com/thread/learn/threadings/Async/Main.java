package com.thread.learn.threadings.Async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();

        Future<String> futureSlow = executorService.submit(new TimeConsumingTask());
        Future<String> futureFast = executorService.submit(new OtherTask());

        while (!futureSlow.isDone()
                &&
                !futureFast.isDone()) {
            System.out.println("Reading and processing not yet finished...");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(futureSlow.get());
        System.out.println(futureFast.get());

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Both tasks finished in :: " + (elapsedTime / 1000000) / 1000 + " seconds");

        executorService.shutdown();
    }
}
