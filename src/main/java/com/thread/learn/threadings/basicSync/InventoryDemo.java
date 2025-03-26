package com.thread.learn.threadings.basicSync;

public class InventoryDemo {
    public static void main(String[] args) {
        InventoryManager invMgr = new InventoryManager();
        Thread threadIssuer = new Thread(invMgr, "IssuerThread");
        Thread threadReceiver = new Thread(invMgr, "ReceiverThread");

        threadIssuer.start();
        threadReceiver.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("The final count of inventory is :: " + invMgr.getInventoryCounter());
    }
}
