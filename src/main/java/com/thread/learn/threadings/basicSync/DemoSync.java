package com.thread.learn.threadings.basicSync;

public class DemoSync {
    public static void main(String[] args) {
        MyRunnableSynced runSync = new MyRunnableSynced();
        Thread thread1 = new Thread(runSync, "Thread1");
        Thread thread2 = new Thread(runSync, "Thread2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The final value of the counter is :: " + runSync.getCounter());
    }
}