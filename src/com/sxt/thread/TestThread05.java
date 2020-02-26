package com.sxt.thread;

/**
 * 多线程实现龟兔赛跑
 * @author Administrator
 *
 */
public class TestThread05 implements Runnable {
	private String winner;
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "====>" + i);
			boolean flag = gameOver(i);
			if (flag) {
				break;
			}
		
		}
	}
	
	public boolean gameOver(int i) {
		if (winner != null) {
			return true;
		} else {
			if (i == 99) {
				System.out.println("winner is :" + Thread.currentThread().getName());
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// 一个资源，两个争夺
		TestThread05 test = new TestThread05();
		
		new Thread(test, "龟").start();
		new Thread(test, "兔").start();
	}
}
