package com.thread.learn.threadings.basic;

public class RunnerWithAnonymous {
    public static void main(String[] args) {
        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        for (int i = 0; i < 6; i++) {
                            System.out.println("Thread number :: " + i);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                });
        t1.start();
    }
}
