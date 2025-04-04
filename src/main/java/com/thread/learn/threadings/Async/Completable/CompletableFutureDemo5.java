package com.thread.learn.threadings.Async.Completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String customerCode = "";
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
                () -> {
                    if (customerCode.isEmpty()) {
                        throw new IllegalArgumentException("Customer code cannot be empty.");
                    } else {
                        try {
                            TimeUnit.SECONDS.sleep(4);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return 200;
                })
                .exceptionally(
                        ex -> {
                            System.err.println("There was an exception:: " + ex.getMessage());
                            return -1;
                        });
        System.out.println("Total points:: " + future.get());
    }
}
