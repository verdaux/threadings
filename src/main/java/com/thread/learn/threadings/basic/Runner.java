package com.thread.learn.threadings.basic;

public class Runner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Thread number :: " + i);
        }
    }
}
