package com.sxt.thread;

/**
 * 利用 sleep 来模拟倒计时
 * @author Administrator
 *
 */
public class TestThread08 implements Runnable {
	private static int num = 10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = num; i >= 0; i--) {
			System.out.println("倒计时：" + i + "秒");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Thread(new TestThread08()).start();
		
		// lambda 函数表达式
		new Thread(() -> {
			// TODO Auto-generated method stub
			for (int i = num; i >= 0; i--) {
				System.out.println("倒计时：" + i + "秒");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
