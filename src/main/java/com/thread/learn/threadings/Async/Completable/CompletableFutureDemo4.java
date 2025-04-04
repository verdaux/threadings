package com.thread.learn.threadings.Async.Completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String customerCode = "";
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
                () -> {
                    if (customerCode.isEmpty()) {
                        throw new IllegalArgumentException("Customer code cannot be empty");
                    } else {
                        try {
                            TimeUnit.SECONDS.sleep(4);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return 200;
                    }
                })
                .handle(
                        (result, ex) -> {
                            if (ex != null) {
                                System.err.println("There was an exception:: " + ex.getMessage());
                                return -1;
                            }
                            return result;
                        });

        System.out.println("Total points:: " + future.get());
    }
}
