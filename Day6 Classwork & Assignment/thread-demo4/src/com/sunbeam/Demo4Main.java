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

class TableThread extends Thread {
	private int num;
	public TableThread(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("While Running: " + t.getState());
		for (int i = 1; i <= 5; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num * i);
			Util.delay(1000);
		}
	}
}


public class Demo4Main {
	public static void main(String[] args) throws Exception {
		Thread t1 = new TableThread(5);
		System.out.println("Before Start: " + t1.getState());
		t1.start();
		System.out.println("After Start: " + t1.getState());
		Util.delay(500);
		System.out.println("While Sleeping: " + t1.getState());
		t1.join();
		System.out.println("After Terminate: " + t1.getState());	
	}
}
