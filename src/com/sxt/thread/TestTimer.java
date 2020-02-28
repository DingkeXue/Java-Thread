package com.sxt.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用 Timer 和 TimerTask 来实现定时启动某个线程
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
		System.out.println("我被唤醒了");
	}
}
