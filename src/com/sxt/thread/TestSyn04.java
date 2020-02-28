package com.sxt.thread;

/**
 * ͬ���飺���ܷ���
 * @author Administrator
 *
 */
public class TestSyn04 {
	public static void main(String[] args) {
		BlockWeb12306 web12306 = new BlockWeb12306();
		
		new Thread(web12306).start();
		new Thread(web12306).start();
		new Thread(web12306).start();
	}
}

class BlockWeb12306 implements Runnable {
	private int tickets = 10;
	private boolean flag = true;
	
	@Override
		public void run() {
			// TODO Auto-generated method stub
			while(flag) {
				try {
					//test01();
					//test02();
					//test03();
					test04();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	// �̲߳���ȫ
	public void test01() throws InterruptedException {
		if (tickets <= 0) {
			flag = false;
			return;
		}
		// ģ�������ӳ�
		Thread.sleep(100);
		
		System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
	}
	
	// �̰߳�ȫ��ͬ�����������ܲ��ã�
	public synchronized void test02() throws InterruptedException {
		if (tickets <= 0) {
			flag = false;
			return;
		}
		
		Thread.sleep(100);
		
		System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
	}
	
	// �̰߳�ȫ��ͬ����
	public void test03() throws InterruptedException {
		synchronized (this) {
			if (tickets <= 0) {
				flag = false;
				return;
			}
			Thread.sleep(100);
			
			System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
		}
	}
	
	// �̰߳�ȫ����������������ķ�Χ������ָ���룬ָ���ݵ������ԣ�
	public void test04() throws InterruptedException {
		// ����û��Ʊ�����
		if (tickets <= 0) {
			flag = false;
			return;
		}
		
		synchronized (this) {
			// �������һ��Ʊ�����
			if(tickets <= 0) {
				flag = false;
				return;
			}
			Thread.sleep(100);
			
			System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
		}
	}
}
