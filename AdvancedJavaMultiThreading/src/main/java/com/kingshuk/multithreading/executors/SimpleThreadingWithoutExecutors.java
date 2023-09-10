package com.kingshuk.multithreading.executors;

import com.kingshuk.multithreading.executors.tasks.Task;

public class SimpleThreadingWithoutExecutors {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			Thread newThread = new Thread(new Task());
			newThread.start();
		}
		
		System.out.println("Main thread says hello to Kingshuk");
	}

}
