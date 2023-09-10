package com.kingshuk.corejava.multithreadingcourse.lockfree.lockfreedatastructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;


public class LockFreeStackImplementation {

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
        private AtomicReference<StackNode<T>> head = new AtomicReference<>();

        //Counter is just to keep count of number of operations performed
        //We are using AtomicInteger here because the counter variable is also
        //Susceptible to race conditions
        private AtomicInteger counter = new AtomicInteger(0);

        public void push(T value) {
            StackNode<T> newHead = new StackNode<>(value);

            //The while loop is just to simulate the fact that multiple threads are trying
            while (true) {
                //1. We need to get the current head
                StackNode<T> currentHead = head.get();
                newHead.nextNode = currentHead;
                if (head.compareAndSet(currentHead, newHead)) {
                    //This means no other thread updated the head in the meantime
                    break;
                } else {
                    //Some other thread has updated the head in the meantime, so
                    //We need to do this all over again.

                    //Before we try again, we'll just wait for 10 nanoseconds
                    LockSupport.parkNanos(10);
                }
            }
            counter.incrementAndGet();
        }

        public T pop() {
            StackNode<T> currentHead = head.get();
            StackNode<T> newHeadNode;

            //If the head is null, there's nothing to pop
            while (currentHead != null) {
                newHeadNode = currentHead.nextNode;
                if (head.compareAndSet(currentHead, newHeadNode)) {
                    break;
                } else {
                    //Some other thread has updated the head in the meantime, so
                    //We need to read the head value once again from the atomic reference
                    //And then try again.
                    LockSupport.parkNanos(10);
                    currentHead = head.get();
                }
            }

            //Increment the counter
            counter.incrementAndGet();
            //return the value
            return Objects.nonNull(currentHead) ? currentHead.getValue() : null;
        }

        public int getCounter(){
            return counter.get();
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
