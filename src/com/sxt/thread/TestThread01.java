package com.sxt.thread;

/**
 * �����̣߳�1.�̳�Thread��  2.ʵ�� Runnable�ӿ�
 * @author Administrator
 *
 */
public class TestThread01 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("�߳�");
		}
	}
	
	public static void main(String[] args) {
		// �����߳�
		TestThread01 testThread01 = new TestThread01();
		testThread01.start(); // ����֤����ִ��
		
		for (int i = 0; i < 100; i++) {
			System.out.println("���߳�");
		}
	}
}
