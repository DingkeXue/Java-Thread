package com.sxt.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ʹ�� Timer �� TimerTask ��ʵ�ֶ�ʱ����ĳ���߳�
 * @author Administrator
 *
 */
public class TestTimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTask myTask = new MyTask();
		timer.schedule(myTask, 1000);
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("�ұ�������");
	}
}
