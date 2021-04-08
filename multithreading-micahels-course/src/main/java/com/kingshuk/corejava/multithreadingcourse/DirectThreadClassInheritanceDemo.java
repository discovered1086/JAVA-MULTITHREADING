package com.kingshuk.corejava.multithreadingcourse;

class MyThread  extends Thread{
    @Override
    public void run() {
        System.out.println("This is a new thread: "+ this.getName());
    }
}
public class DirectThreadClassInheritanceDemo {

    public static void main(String[] args) {
        Thread thread = new MyThread ();

        thread.setName("Worker thread");

        System.out.println("Before starting the new thread, in the thread: "+ Thread.currentThread().getName());
        thread.start();

        System.out.println("After starting the new thread, in the thread: "+ Thread.currentThread().getName());
    }
}
