package com.sxt.thread;

/**
 * 线程的优先级
 * @author Administrator
 *
 */
public class TestThread12 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "=====>" + Thread.currentThread().getPriority() );
	}
	
	public static void main(String[] args) {
		TestThread12 testThread = new TestThread12();
		Thread thread0 = new Thread(testThread, "a");
		Thread thread1 = new Thread(testThread, "b");
		Thread thread2 = new Thread(testThread, "c");
		Thread thread3 = new Thread(testThread, "d");
		Thread thread4 = new Thread(testThread, "e");
		Thread thread5 = new Thread(testThread, "f");
		
		// 设置线程优先级
		thread0.setPriority(Thread.MAX_PRIORITY);
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MIN_PRIORITY);
		thread4.setPriority(2);
		thread5.setPriority(3);
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
