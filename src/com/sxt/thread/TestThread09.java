package com.sxt.thread;

/**
 * yield���ж� ֱ���жϣ��������״̬���ó�CPU����Ȩ
 * @author Administrator
 *
 */
public class TestThread09 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("yield:====>" + i);
		}
	}
	
	public static void main(String[] args) {
		new Thread(new TestThread09()).start();
		
		for (int i = 0; i < 100; i++) {
			if ((i % 20) == 0) {
				Thread.yield();
			} else {
				System.out.println("main====>" + i);
			}
		}
	}
}
