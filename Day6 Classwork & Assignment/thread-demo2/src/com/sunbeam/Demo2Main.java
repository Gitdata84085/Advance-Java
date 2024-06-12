package com.sunbeam;

import java.util.Iterator;

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
		Thread t = Thread.currentThread();
		for (int i = 1; i <= 15; i++) {
			System.out.printf("MyThread (name=%s, id=%d): %d\n", t.getName(), t.getId(), i);
			Util.delay(1000);
		}
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		for (int i = 1; i <= 10; i++) {
			System.out.printf("MyRunnable (name=%s, id=%d): %d\n", t.getName(), t.getId(), i);
			Util.delay(1000);
		}
	}
}

public class Demo2Main {
	public static void main(String[] args) {
		// main thread ... non-daemon thread
		
		// t1 -- daemon thread i.e. background thread
		Thread t1 = new MyThread();
		t1.setName("MyDaemon");
		t1.setDaemon(true);
		t1.start();
		
		// t2 -- non-daemon thread i.e. forground thread
		MyRunnable r = new MyRunnable();
		Thread t2 = new Thread(r);
		t2.setName("MyNonDaemon");
		t2.setDaemon(false); // by default
		t2.start();
		
		Thread t = Thread.currentThread();
		for (int i = 1; i <= 5; i++) {
			System.out.printf("main (name=%s, id=%d): %d\n", t.getName(), t.getId(), i);
			Util.delay(1000);
		}
		System.out.println("bye!");
	}
}
