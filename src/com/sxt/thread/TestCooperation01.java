package com.sxt.thread;

import java.awt.Container;

/**
 * 
 * ����Э�����̷ܳ�   ��������������ģʽ
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

// ������
class Productor extends Thread {
	SynContainer container;
	
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("����������" + i);
			try {
				container.push(new Data(i));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
// ������
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
				System.out.println("�������ѣ�" + container.pop().id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
// ������
class SynContainer {
	Data[] data = new Data[10];
	int count = 0;
	
	// �洢 ����
	public synchronized void push(Data newdata) throws InterruptedException {
		// ��ʱֹͣ����
		if (count == data.length) {
			this.wait();
		}
		data[count++] = newdata;
		// ������֪ͨ������
		this.notifyAll();
	}
	
	// ȡ�� ����
	public synchronized Data pop() throws InterruptedException {
		// ������Ϊ��ʱֹͣ����
		if (count == 0) {
			// �߳����������ͷ�����������֪ͨ���ѽӴ�����
			this.wait(); 
		}
		// ��������������ݣ���ʼ����
		this.notifyAll();
		count--;
		Data popData = data[count];
		return popData;
	}
}
// ����
class Data {
	int id;

	public Data(int id) {
		super();
		this.id = id;
	}
	
}