package com.kingshuk.corejava.multithreadingcourse.threadcoordination.threadstoppage;

public class ThreadInterruptDemo {

    public static void main(String[] args) {
        Thread thread = new BlockingThread();

        thread.start();

        System.out.println("Done from the main thread");

        thread.interrupt();
    }

    private static class BlockingThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(500000000);
            } catch (InterruptedException e) {
                System.out.println("Exiting the current thread");
            }
        }
    }
}
