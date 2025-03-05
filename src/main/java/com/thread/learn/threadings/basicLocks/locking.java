package com.thread.learn.threadings.basicLocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class locking {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    Random random = new Random();

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.add(random.nextInt(100));
        }

    }

    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l2.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    void printer() {
        System.out.println("list1:: " + l1.size() + "\n list2:: " + l2.size());
    }

    public static void main(String[] args) {
        locking lock = new locking();
        System.out.println("starting...");
        Long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                lock.process();
            }

        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {

                lock.process();
            }

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();
        System.out.println("time taken:: " + (end - start));

        lock.printer();
    }
}
