package com.sxt.thread;

/**
 * �ػ��̣߳�JVMֻ��ע�û��߳��Ƿ���������õȴ��ػ��߳̽���
 * @author Administrator
 *
 */
public class TestThread13 {
	public static void main(String[] args) {
		Woman man = new Woman();
		Earth earth = new Earth();
		
		new Thread(man).start();
		// �߳�Ĭ�϶����û��߳�
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
			System.out.println("ת��ת...");
		}
	}
}