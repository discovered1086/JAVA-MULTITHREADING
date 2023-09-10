package com.kingshuk.multithreading.threadprogramming;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Counter c = new Counter(1);
		Producer p = new Producer(c);
		Consumer con = new Consumer(c);

	}
}
class Producer extends Thread
{
	final Counter c ;
	Producer(Counter c)
	{
		this.c = c;
		start();
	}
	public void run()
	{
	while(true){
		try{
			Thread.sleep(100);
			synchronized(c)
			{
			c.notifyAll();
			System.out.println("Incrementd Counter" );
    		c.increment();
	        c.wait();
			}
		}
		catch(InterruptedException iex)
		{
			iex.printStackTrace();
		}
		
		
    	}
	}	
}

class Consumer extends Thread
{
	final Counter c;
	Consumer(Counter c)
	{
		this.c = c;
		start();
	}

	@Override
 	public void run()
 	{
 		while(true){
 			try{
 			synchronized(c)
 			{
 				c.notifyAll();
 				System.out.println("Get Incrementd Value" + c.getCount());
 				c.wait();
 			}
 				Thread.sleep(1000);
 			}
 			catch(InterruptedException iex)
 			{
 				iex.printStackTrace();
 			}	
 		}
 	}
	
}

class Counter
{
	int count = 0;
	Counter(int count)
	{
		this.count = count;
	}
	public void increment(){
		count++;
	}
	public int getCount()
	{
		return count;
	}
}