package com.sxt.thread;

/**
 * ��ȡ�̵߳Ļ�����Ϣ
 * @author Administrator
 *
 */
public class TestThread14 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		TestThread14 testThread14 = new TestThread14();
		Thread thread = new Thread(testThread14);
		thread.setName("����");
		thread.start();
		System.out.println(thread.isAlive());
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(thread.isAlive());
	}
}
