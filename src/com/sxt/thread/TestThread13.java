package com.sxt.thread;

/**
 * 守护线程：JVM只关注用户线程是否结束，不用等待守护线程结束
 * @author Administrator
 *
 */
public class TestThread13 {
	public static void main(String[] args) {
		Woman man = new Woman();
		Earth earth = new Earth();
		
		new Thread(man).start();
		// 线程默认都是用户线程
		Thread eThread = new Thread(earth);
		eThread.setDaemon(true);
		eThread.start();
		
	}
}

class Woman implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 365; i++) {
			System.out.println("alive...");
		}
		System.out.println("dead");
	}
}

class Earth implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("转啊转...");
		}
	}
}