package com.sxt.thread;

/**
 * 开启线程：1.继承Thread类  2.实现 Runnable接口
 * @author Administrator
 *
 */
public class TestThread01 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("线程");
		}
	}
	
	public static void main(String[] args) {
		// 创建线程
		TestThread01 testThread01 = new TestThread01();
		testThread01.start(); // 不保证立即执行
		
		for (int i = 0; i < 100; i++) {
			System.out.println("主线程");
		}
	}
}
