package com.kingshuk.multithreading.executors.withexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.kingshuk.multithreading.executors.tasks.Task;

public class SimpleThreadingWithExecutors {

	public static void main(String[] args) {

		// Create the pool
		ExecutorService service = Executors.newFixedThreadPool(5);

		// Submit the tasks for execution
		for (int i = 0; i < 10; i++) {
			service.execute(new Task());
		}

	}

}
