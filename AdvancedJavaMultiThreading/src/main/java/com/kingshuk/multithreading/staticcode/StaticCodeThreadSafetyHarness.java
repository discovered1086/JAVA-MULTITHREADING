package com.kingshuk.multithreading.staticcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.kingshuk.multithreading.staticcode.pojo.Person;

public class StaticCodeThreadSafetyHarness {

	public static void main(String[] args) throws InterruptedException {

		Person person = new Person();
		person.setAge(33);
		person.setName("Kingshuk");

		ExecutorService service = Executors.newFixedThreadPool(5);

		ScheduledExecutorService service2 = Executors.newScheduledThreadPool(5);

		service2.schedule(() -> StaticCodeThreadSafetyHarness.printPerson(person), 10, TimeUnit.SECONDS);

		for (int i = 0; i < 5; i++) {
			service.submit(() -> StaticCodeThreadSafetyHarness.printPerson(person));
		}

		person.setName("Deeksha");

		Thread.sleep(5000);
		System.out.println("back in the main thread....\n" + person);
	}

	public static void printPerson(Person person) {
		System.out.println(Thread.currentThread().getName() + " prints..\n" + person + "\n");
	}

}
