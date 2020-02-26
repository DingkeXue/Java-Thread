package com.sxt.thread;

/**
 * 线程的联合 join() 当调用join()方法时，必须等该线程执行完才接下往下执行 
 * @author Administrator
 *
 */
public class TestThread10 {
	public static void main(String[] args) {
		new Thread(new Father()).start();
	}
}

// 线程 A
class Father implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("想炒菜");
		
		Thread son = new Thread(new Son());
		son.start();
		// 联合 线程B执行完后再往下执行
		try {
			son.join();
			System.out.println("洗菜");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("切菜，炒菜");
	}
}

// 线程B
class Son implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("买菜...");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("买菜花了"+i+"分钟");
		}
		System.out.println("买菜回来了");
	}
}