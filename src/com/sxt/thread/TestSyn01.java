package com.sxt.thread;

/**
 * ������ͬһ������ͬһʱ�䣬����̹߳�ͬ������Դ
 * �������ڲ���ʱ��֤���ݵİ�ȫ����Ϊ�������Ϳ����������Ƕ������Դ
 * @author Administrator
 *
 */
public class TestSyn01 {
	public static void main(String[] args) {
		Web12306 web12306 = new Web12306();
		new Thread(web12306).start();
		new Thread(web12306).start();
		new Thread(web12306).start();
		
	}
}

class Web12306 implements Runnable {
	private int tickets = 10;
	private boolean flag = true;
	@Override
	// ͬ������
	public synchronized void run() {
		// TODO Auto-generated method stub
		while(flag) {
			sub();
		}
	}
	
	public void sub() {
		if (tickets < 1) {
			flag = false;
			return;
		}
		
		// ģ���ӳ�
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
	}
}
