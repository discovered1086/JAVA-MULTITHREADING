package com.kingshuk.multithreading.threadprogramming;

/**
 * Created with IntelliJ IDEA.
 * User: co21321
 * Date: 3/25/15
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class NormalTask implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            System.out.println("This is the "+Thread.currentThread().getName()+" talking.....hola");
        }
    }
}
