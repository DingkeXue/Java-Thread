package com.sxt.thread;

/**
 * 关闭线程
 * @author Administrator
 *
 */
public class TestThread07 implements Runnable {
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			System.out.println("运行中...");
		}
	}
	
	// 停止线程运行方法
	public void stop() {
		this.flag = false;
	}
	
	public static void main(String[] args) {
		TestThread07 test = new TestThread07();
		new Thread(test).start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 99) {
				test.stop();
			} else {
				System.out.println("main---->" + i);
			}
		}
	}
	
}
