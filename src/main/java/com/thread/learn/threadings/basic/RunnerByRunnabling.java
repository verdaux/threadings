package com.thread.learn.threadings.basic;

public class RunnerByRunnabling implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Runnable thread number:: " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnerByRunnabling());
        t1.start();
    }
}
