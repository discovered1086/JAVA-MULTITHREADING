package com.kingshuk.multithreading.executors.tasks;

public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" says hello to Kingshuk");		
	}

}
