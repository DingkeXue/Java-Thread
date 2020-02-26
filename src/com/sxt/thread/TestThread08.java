package com.sxt.thread;

/**
 * ���� sleep ��ģ�⵹��ʱ
 * @author Administrator
 *
 */
public class TestThread08 implements Runnable {
	private static int num = 10;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = num; i >= 0; i--) {
			System.out.println("����ʱ��" + i + "��");
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
		
		// lambda �������ʽ
		new Thread(() -> {
			// TODO Auto-generated method stub
			for (int i = num; i >= 0; i--) {
				System.out.println("����ʱ��" + i + "��");
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
