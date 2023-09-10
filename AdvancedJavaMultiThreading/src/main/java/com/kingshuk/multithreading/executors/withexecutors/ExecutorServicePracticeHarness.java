package com.kingshuk.multithreading.executors.withexecutors;

import com.google.common.base.Stopwatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicePracticeHarness {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Future<Long> submit = executorService.submit(()-> {
			long sum= 0L;
						
			for(int i = 0; i<10;i++) {
				long theNumber;
				theNumber = Math.round(Math.random()*100);
				System.out.println("First task: Adding number: "+theNumber+" at sequence: "+i);
				sum +=theNumber;
				Thread.sleep(2000);
			}
			return sum;
		});
		
		Future<Long> submit2 = executorService.submit(()-> {
			long sum= 0L;
						
			for(int i = 0; i<10;i++) {
				long theNumber;
				theNumber = Math.round(Math.random()*100);
				theNumber=theNumber*theNumber;
				System.out.println("Second task: Adding number: "+theNumber+" at sequence: "+i);
				sum +=theNumber;
				Thread.sleep(2000);
			}
			return sum;
		});
		
		
		try {
			System.out.println("First task returned: "+ submit.get());
			System.out.println("Second task returned: "+submit2.get());
			
			for(int i=0; i<10; i++) {
				System.out.println("Parent thread");
				//Thread.sleep(1000);
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}

}
