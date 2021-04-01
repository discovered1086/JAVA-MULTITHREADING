package com.kingshuk.multithreading.threadprogramming;

public class Thread2Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		ThreadGroup tg = new ThreadGroup("Group1");
		tg.setMaxPriority(8);
		Thread1Test t = new Thread1Test(tg,"Thread1");
		t.setPriority(Thread.MAX_PRIORITY); // 10
		t.start();
		Thread1Test t1 = new Thread1Test(tg,"Thread2");
		t.setPriority(7); // 5
		t1.start();
		Thread1Test t2 = new Thread1Test(tg,"Thread3");
		t.setPriority(Thread.MIN_PRIORITY); // 1
		t2.start();
		try
		{
		Thread.sleep(5000);
		}
		catch(InterruptedException iex)
		{
			iex.printStackTrace();
		}
		tg.stop();
		
	}

}
