package com.thread.learn.threadings.basicSync;

public class MyRunnableSynced implements Runnable {

    private int counter = 0;

    @Override
    public void run() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (this) {
                counter++; // critical section
            }
        }

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println(Thread.currentThread().getName() + " increased the counter to:: " + counter + " in "
                + elapsedTime / 1000000 + " milliseconds.");
    }

    public int getCounter() {
        return counter;
    }

    /*
     * public synchronized void someMethod()
     * {
     * //Critical section here
     * //The monitor is implicitly the monitor of the current object to which the
     * method belongs.
     * }
     * 
     */
}
