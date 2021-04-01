package com.kingshuk.multithreading.threadprogramming;

/**
 * Created with IntelliJ IDEA.
 * User: co21321
 * Date: 3/25/15
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTest2 {

    public static void main(String [] args){
        Thread thread = new Thread(new ReminderTask());
        Thread thread1 = new Thread(new NormalTask());
        thread.setName("Notification");
        thread1.setName("Normal");
        thread.start();
        thread1.start();


    }
}
