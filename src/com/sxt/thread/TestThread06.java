package com.sxt.thread;

/**
 * 静态代理:真实角色  代理角色
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

// 真实角色
class Man implements Marry {

	@Override
	public void getMarried() {
		System.out.println("man and woman get married!");
	}
}

// 代理角色
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
