package com.sxt.thread;

/**
 * 并发：同一个对象，同一时间，多个线程共同抢夺资源
 * 加锁：在并发时保证数据的安全，分为方法锁和块锁。锁的是对象的资源
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
	// 同步方法
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
		
		// 模拟延迟
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
	}
}
