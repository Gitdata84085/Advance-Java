package com.sunbeam;

class Util {
	public static void delay(int ms) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("MyThread: " + i);
			Util.delay(1000);
		}
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 15; i++) {
			System.out.println("MyRunnable: " + i);
			Util.delay(1000);
		}
	}
}

public class Demo3Main {
	public static void main(String[] args) throws Exception {
		// main thread ...
		
		Thread t1 = new MyThread();
		t1.start(); // MyThread.run() ... t1 thread
		
		MyRunnable r = new MyRunnable();
		Thread t2 = new Thread(r);
		t2.start(); // MyRunnable.run() ... t2 thread
		
		for (int i = 1; i <= 5; i++) {
			System.out.println("main: " + i);
			Util.delay(1000);
		}
		
		System.out.println("Main thread waiting for t1 thread...");
		t1.join(); // pause current thread (main) for given thread (t1)
		System.out.println("Main thread waiting for t2 thread...");
		t2.join(); // pause current thread (main) for given thread (t2)
		System.out.println("Bye!");
	}
}
