package com.thread.learn.threadings.basicSync;

import java.util.Scanner;

public class Processor extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Processor");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }

    public static void main(String[] args) {
        Processor proc = new Processor();
        proc.start();

        System.out.println("Press return to stop the process.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        proc.shutdown();
    }

}
