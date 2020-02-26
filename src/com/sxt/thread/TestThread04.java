package com.sxt.thread;

/**
 * ���߳�ʵ����Ʊ
 * @author Administrator
 *
 */
public class TestThread04 implements Runnable {
	private static int tickes = 100;
	@Override
	public void run() {
		while(true) {
			if (tickes < 1) {
				break;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "===>" + tickes--);
		}
	}
	
	public static void main(String[] args) {
		TestThread04 test = new TestThread04();
		new Thread(test, "��1").start();
		new Thread(test, "��2").start();
		new Thread(test, "��3").start();
	}
}
