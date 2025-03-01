package com.thread.learn.threadings.basicSync;

public class CountSyncer {
    private int count = 0;

    public static void main(String[] args) {
        CountSyncer cs = new CountSyncer();
        cs.doWork();
    }

    public synchronized void incrementer() {
        count++;
    }

    public void doWork() {
        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            incrementer();
                        }
                    };
                });
        Thread t2 = new Thread(
                new Runnable() {
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            incrementer();
                        }
                    };
                });
        t1.start();
        t2.start();

        try {
            t1.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("count:: " + count);
    }
}
