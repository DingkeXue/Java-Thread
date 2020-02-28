package com.sxt.thread;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * ²¢·¢ÈÝÆ÷
 * @author Administrator
 *
 */
public class TestSyn07 {
	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for (int i = 0; i < 1000; i++) {
			new Thread(()-> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(list.size());
	}
}
