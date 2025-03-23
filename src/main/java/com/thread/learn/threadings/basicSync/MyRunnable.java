package com.thread.learn.threadings.basicSync;

public class MyRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {

        long startTime = System.nanoTime();

        for (int i = 0; i < 1_000_000; i++) {
            count++;
        }

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println(Thread.currentThread().getName() + " increased the counter up to:: " + count
                + " in " + elapsedTime / 1000000 + " milliseconds");
    }

    public int getCount() {
        return count;
    }

}
