package com.sunbeam;

import java.util.Scanner;

class TableThread extends Thread {
	private int num;
	public TableThread(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.printf("%d * %d = %d\n", num, i, num * i);
				Thread.sleep(3000);
			}
		} 
		catch (InterruptedException e) {
			System.out.println("Forcibly Wakeup...");
		}
	}
}
public class Demo6Main {
	public static void main(String[] args) {
		Thread t1 = new TableThread(5);
		t1.start();
		
		System.out.println("Press enter to interrupt the thread...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		t1.interrupt();
		
		System.out.println("Bye!");
	}
}







