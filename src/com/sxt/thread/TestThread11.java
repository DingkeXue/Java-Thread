package com.sxt.thread;

/**
 * 线程的几个状态：new runnable wait terminated
 * @author Administrator
 *
 */
public class TestThread11 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread state = new Thread(new TestThread11());
		System.out.println(state.getState()); // new 
		
		state.start();
		System.out.println(state.getState()); // runnable
		
		while(state.getState() != Thread.State.TERMINATED) {
			System.out.println(state.getState()); // timed_waiting
		}
		System.out.println(state.getState()); // terminated
	}
}
