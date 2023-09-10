package com.kingshuk.corejava.multithreadingcourse.lockfree.lockfreedatastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class LockBasedStackImplementation {

    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    private static class StackNode<T> {
        @NonNull
        private T value;

        //Pointer to the next node
        private StackNode<T> nextNode;
    }

    @Data
    private static class StackImplementation<T> {
        private StackNode<T> head;

        //Counter is just to keep count of number of operations performed
        private int counter;

        public synchronized void push(T value) {
            StackNode<T> newHead = new StackNode<>(value);
            newHead.nextNode = head;
            head = newHead;
            counter++;
        }

        public synchronized T pop() {
            if (head == null) {
                counter++;
                return null;
            }
            //Get the value from the head
            T value = head.getValue();

            //Set the head to the current head's next node
            head = head.getNextNode();

            //return the value
            return value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //Checking the performance
        StackImplementation<Integer> implementation = new StackImplementation<>();
        Random random = new Random();

        for (int i = 0; i <= 1000000; i++) {
            //We are doing this because we want to make sure the stack is not
            //empty when the threads start to perform operations on the stack
            implementation.push(random.nextInt());
        }

        //Now we create a list for the threads
        List<Thread> listOfThreads = new ArrayList<>();

        //There are some threads that are going to push and
        //other threads that are going to pop
        int pushingThreads = 4;
        int poppingThreads = 4;

        for (int i = 0; i <= pushingThreads; i++) {
            Thread thread = new Thread(() -> {
                //The infinite loop is to simulate that the threads are always alive
                while (true) {
                    implementation.push(random.nextInt());
                }
            });

            //Setting the thread to be a daemon thread
            thread.setDaemon(true);
            listOfThreads.add(thread);
        }

        for (int i = 0; i <= poppingThreads; i++) {
            Thread thread = new Thread(() -> {
                //The infinite loop is to simulate that the threads don't terminate
                while (true) {
                    implementation.pop();
                }
            });

            //Setting the thread to be a daemon thread
            thread.setDaemon(true);
            listOfThreads.add(thread);
        }

        listOfThreads.forEach(Thread::start);

        //We're going to measure the performance by checking
        //How many operations were performed by the threads within a certain amount of time
        //Here we are using 10 seconds as the window
        TimeUnit.SECONDS.sleep(10);

        System.out.printf("%,d operations were performed by the threads in 10 seconds%n",
                implementation.getCounter());

    }
}
