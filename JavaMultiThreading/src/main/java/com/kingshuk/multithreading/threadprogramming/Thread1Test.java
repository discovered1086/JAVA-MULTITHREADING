package com.kingshuk.multithreading.threadprogramming;

public class Thread1Test extends Thread {
 
	public Thread1Test(ThreadGroup group, String name)
	{
	super(group,name);
	
	}
	public Thread1Test(String name)
	{
		super(name);
	}

	public void run() 
	{
		for(int i = 0 ; i < 10; i ++){
			System.out.println(Thread.currentThread().getName() + " " + i);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException iex)
			{
				iex.printStackTrace();
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread1Test t = new Thread1Test("Thread1");
		t.start(); 
		
		Thread t1 = new Thread(new MyRunnable(),"Thread2");
		t1.start();   
  		for(int i = 0 ; i < 10; i ++)
			System.out.println(Thread.currentThread().getName() + " " + i);
	}
}

class MyRunnable implements Runnable 
{
	public void run(){
		for(int i = 0 ; i < 10; i ++)
			System.out.println(Thread.currentThread().getName() + " " + i);
	}
}
