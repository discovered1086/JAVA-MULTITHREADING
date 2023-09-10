package com.kingshuk.multithreading.completablefuture;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MoreExecutorServicePracticeHarness {

	public static void main(String[] args) {
		ExecutorService schedule = Executors.newFixedThreadPool(5);

		// Submit the task and accept a placeholder object for return value
		Future<Integer> submit = schedule.submit(() -> new Random().nextInt());

		try {
			Integer returnValue = submit.get(); //Blocking operation
			System.out.println(returnValue);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
