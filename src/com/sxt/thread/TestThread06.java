package com.sxt.thread;

/**
 * ��̬����:��ʵ��ɫ  �����ɫ
 * @author Administrator
 *
 */
public class TestThread06 {
	public static void main(String[] args) {
		new Company(new Man()).getMarried();
	}
}

interface Marry {
	void getMarried();
}

// ��ʵ��ɫ
class Man implements Marry {

	@Override
	public void getMarried() {
		System.out.println("man and woman get married!");
	}
}

// �����ɫ
class Company implements Marry {
	private Marry marry;

	public Company(Marry marry) {
		super();
		this.marry = marry;
	}

	@Override
	public void getMarried() {
		ready();
		this.marry.getMarried();
		afer();
	}
	
	public void ready() {
		
	}
	
	public void afer() {
		
	}
	
}
