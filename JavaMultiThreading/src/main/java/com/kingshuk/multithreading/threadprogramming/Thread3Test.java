package com.kingshuk.multithreading.threadprogramming;

public class Thread3Test
implements Runnable
{
	String fname;
	String lname;
	MyClass c ;
	public Thread3Test(String fname, String lname, MyClass c)
	{
		this.fname = fname;
		this.lname = lname;
		this.c = c;
		Thread t = new Thread(this);//
		t.start();
	}
	
	public void run()
	{
		synchronized(c){
		c.print(fname,lname);
		}
	}

	public static void main(String[] args) {
		MyClass cc = new MyClass();
		Thread3Test t1 = new Thread3Test("Amit","Dev",cc);
		Thread3Test t2 = new Thread3Test("Gautam","Sen",cc);
		Thread3Test t3 = new Thread3Test("Rajesh","Roy",cc);
	}
	
	}

class MyClass
{
	
 void printFirst(String fname)
	{
		System.out.print(fname + " ");
	}
	
 void printLast(String lname)
	{
		System.out.println(lname);
	}
	
 void print(String fname, String lname) 
	{
		// synchronized block for static class
		
	//	synchronized(Thread3Test.class){
		printFirst(fname);	
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException iex)
		{
			iex.printStackTrace();
		}
		printLast(lname);
		// }
		
	}

}
