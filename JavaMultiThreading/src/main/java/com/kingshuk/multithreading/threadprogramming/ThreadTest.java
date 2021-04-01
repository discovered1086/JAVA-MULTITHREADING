package com.kingshuk.multithreading.threadprogramming;

/**
 * Created by IntelliJ IDEA.
 * User: CO21321
 * Date: Apr 25, 2013
 * Time: 6:16:57 AM
 * To change this template use File | Settings | File Templates.
 */

class ThreadExceution implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " scored " + i + " goal.....");
            if (i % 2 == 0)
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
        }

    }
}


public class ThreadTest {

    public static void main(String[] args) {
        ThreadExceution t1 = new ThreadExceution();
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t1);
        th1.setName("Barcelona");
        th2.setName("Bayern Munich");
        th1.start();
        th2.start();

    }
}
