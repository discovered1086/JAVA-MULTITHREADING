package com.kingshuk.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.kingshuk.multithreading.completablefuture.orderprocessing.Address;

public class InterviewProgram2 {
	
	private int a = 10;  //heap
	
	private boolean trigger = false;  //heap

	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(5);
		
		InterviewProgram2 i = new InterviewProgram2();
		
		Address address = Address.builder().city("New York").build();
		
		for (int j = 0; j < 2; j++) {
			e.submit(() -> i.printAddress(address));			
		}
		
	}
	
	public void printAddress(Address address) {
		Address address2 = Address.builder().city("Jersey City").build();
		System.out.println(a);
		System.out.println(trigger);
		System.out.println(address.toString());
		System.out.println(address2);
	}

}
