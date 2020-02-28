package com.sxt.thread;

/**
 * 同步块：性能分析
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
	
	// 线程不安全
	public void test01() throws InterruptedException {
		if (tickets <= 0) {
			flag = false;
			return;
		}
		// 模拟网络延迟
		Thread.sleep(100);
		
		System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
	}
	
	// 线程安全：同步方法（性能不好）
	public synchronized void test02() throws InterruptedException {
		if (tickets <= 0) {
			flag = false;
			return;
		}
		
		Thread.sleep(100);
		
		System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
	}
	
	// 线程安全：同步块
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
	
	// 线程安全：尽可能锁定合理的范围（不是指代码，指数据的完整性）
	public void test04() throws InterruptedException {
		// 考虑没有票的情况
		if (tickets <= 0) {
			flag = false;
			return;
		}
		
		synchronized (this) {
			// 考虑最后一张票的情况
			if(tickets <= 0) {
				flag = false;
				return;
			}
			Thread.sleep(100);
			
			System.out.println(Thread.currentThread().getName() + "===>" + tickets--);
		}
	}
}
