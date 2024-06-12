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

public class Demo7Main {
	public static void main(String[] args) {
		class MyRunnable implements Runnable {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("First (Class): " + i);
					Util.delay(1000);
				}				
			}
		}
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("Second (Anon): " + i);
					Util.delay(1000);
				}				
			}
		});
		t2.start();
		
		Thread t3 = new Thread( () -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Third (Lambda): " + i);
				Util.delay(1000);
			}			
		} );
		t3.start();
	}
}
