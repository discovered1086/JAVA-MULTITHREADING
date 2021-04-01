package com.kingshuk.multithreading.threadprogramming;



/**
 * Created with IntelliJ IDEA.
 * User: co21321
 * Date: 3/25/15
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReminderTask implements Runnable {
    @Override
    public void run() {
        System.out.println(new DateCompareHelper().dateCompare() ? "This is " + Thread.currentThread().getName() + " Talking...It's time to wake up buddy" : "Not yet buddy");

    }
}
