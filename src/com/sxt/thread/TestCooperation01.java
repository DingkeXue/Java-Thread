package com.sxt.thread;

import java.awt.Container;

/**
 * 
 * 并发协作：管程法   生产者与消费者模式
 * @author Administrator
 *
 */
public class TestCooperation01 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}
}

// 生产者
class Productor extends Thread {
	SynContainer container;
	
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("正在生产：" + i);
			try {
				container.push(new Data(i));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
// 消费者
class Consumer extends Thread {
	SynContainer container;
	
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				System.out.println("正在消费：" + container.pop().id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
// 缓存区
class SynContainer {
	Data[] data = new Data[10];
	int count = 0;
	
	// 存储 生成
	public synchronized void push(Data newdata) throws InterruptedException {
		// 何时停止生产
		if (count == data.length) {
			this.wait();
		}
		data[count++] = newdata;
		// 生产后通知消费者
		this.notifyAll();
	}
	
	// 取出 消费
	public synchronized Data pop() throws InterruptedException {
		// 容器中为空时停止消费
		if (count == 0) {
			// 线程阻塞，会释放锁。生产者通知消费接触阻塞
			this.wait(); 
		}
		// 如果容器内有内容，则开始消费
		this.notifyAll();
		count--;
		Data popData = data[count];
		return popData;
	}
}
// 数据
class Data {
	int id;

	public Data(int id) {
		super();
		this.id = id;
	}
	
}