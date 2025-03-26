package com.thread.learn.threadings.basicSync;

public class InventoryManager implements Runnable {
    private int inventoryCounter = 2_00_000;

    @Override
    public void run() {
        long startTime = System.nanoTime();
        String inventoryFunction = Thread.currentThread().getName();

        if (inventoryFunction.equals("IssuerThread")) {
            for (int i = 0; i < 1_00_000; i++) {
                synchronized (this) {
                    inventoryCounter--;
                }
            }
        } else if (inventoryFunction.equals("ReceiverThread")) {
            for (int i = 0; i < 1_00_000; i++) {
                synchronized (this) {
                    inventoryCounter++;
                }
            }
        }
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("The thread " + Thread.currentThread().getName() + " took " + (elapsedTime / 1000000)
                + " milliseconds to increment the counter to :: " + inventoryCounter);

    }

    public int getInventoryCounter() {
        return inventoryCounter;
    }

}
