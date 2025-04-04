package com.thread.learn.threadings.Async.Completable.Challenge;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StepOneSolutionFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();

        Future futureSum = executorService.submit(new SumOfEvenTask());
        Future futureSquare = executorService.submit(new SumOfSquaresTask());

        if (!futureSum.isDone()
                &&
                !futureSquare.isDone()) {
            System.out.println("Sum of even numbers:: " + futureSum.get());
            System.out.println("Sum of squares:: " + futureSquare.get());
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total time:: " + (elapsedTime / 1000000) / 1000 + " seconds");

        executorService.shutdown();
    }
}
