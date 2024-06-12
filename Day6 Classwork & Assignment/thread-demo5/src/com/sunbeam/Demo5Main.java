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
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num * i);
		//	Util.delay(1000);
		}
	}
}


public class Demo5Main {
	public static void main(String[] args) {
		Thread t1 = new TableThread(5);
		t1.setPriority(Thread.MIN_PRIORITY); // 1
		Thread t2 = new TableThread(7);
		t1.setPriority(Thread.NORM_PRIORITY); // 5
		Thread t3 = new TableThread(9);
		t3.setPriority(Thread.MAX_PRIORITY); // 10
		// ideally higher priority thread is scheduled before lower priority thread.
		// however thread output is OS dependent
		t1.start();
		t2.start();
		t3.start();
	}
}
