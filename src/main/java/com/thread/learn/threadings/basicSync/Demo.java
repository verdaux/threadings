package com.thread.learn.threadings.basicSync;

public class Demo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "Thread1");
        Thread t2 = new Thread(myRunnable, "Thread2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value of counter is:: " + myRunnable.getCount());
    }
}
