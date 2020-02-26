package com.sxt.thread;

/**
 * �̵߳����� join() ������join()����ʱ������ȸ��߳�ִ����Ž�������ִ�� 
 * @author Administrator
 *
 */
public class TestThread10 {
	public static void main(String[] args) {
		new Thread(new Father()).start();
	}
}

// �߳� A
class Father implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�보��");
		
		Thread son = new Thread(new Son());
		son.start();
		// ���� �߳�Bִ�����������ִ��
		try {
			son.join();
			System.out.println("ϴ��");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�вˣ�����");
	}
}

// �߳�B
class Son implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("���...");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��˻���"+i+"����");
		}
		System.out.println("��˻�����");
	}
}