package com.sxt.thread;

/**
 * �ر��߳�
 * @author Administrator
 *
 */
public class TestThread07 implements Runnable {
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			System.out.println("������...");
		}
	}
	
	// ֹͣ�߳����з���
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
