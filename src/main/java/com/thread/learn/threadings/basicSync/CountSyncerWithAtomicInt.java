package com.thread.learn.threadings.basicSync;

import java.util.concurrent.atomic.AtomicInteger;

public class CountSyncerWithAtomicInt {
    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        CountSyncerWithAtomicInt cs = new CountSyncerWithAtomicInt();
        cs.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            count.incrementAndGet();
                        }
                    };
                });
        Thread t2 = new Thread(
                new Runnable() {
                    public void run() {
                        for (int i = 0; i < 10000; i++) {
                            count.incrementAndGet();
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
