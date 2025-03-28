package com.thread.learn.threadings.basic;

public class Runner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Thread number :: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runner r1 = new Runner();
        r1.start();
    }
}
