package com.sxt.thread;

/**
 * 同步块（目标更明确）：安全 synchronized(对象) {}
 * @author Administrator
 * 取钱问题：加锁（安全）
 */
public class TestSyn03 {
	public static void main(String[] args) {
		Account2 account = new Account2(10);
		Drawing2 drawing = new Drawing2(account, 9);
		Drawing2 drawing2 = new Drawing2(account, 9);
		new Thread(drawing).start();
		new Thread(drawing2).start();
	}
}

// 账户
class Account2 {
	int total;
	
	public Account2(int total) {
		// TODO Auto-generated constructor stub
		super();
		this.total = total;
	}
}

// 取钱
class Drawing2 implements Runnable {
	private Account2 account;
	private int getMoney;
	public Drawing2(Account2 account, int getMoney) {
		super();
		this.account = account;
		this.getMoney = getMoney;
	}
	
	@Override
	public void run() {
		// 提高性能
		if (account.total <= 0) {
			return;
		}
		// 同步块
		synchronized (account) {
			if (this.account.total > getMoney) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.account.total -= getMoney;
				System.out.println("取钱成功！余额：" + this.account.total);
			} else {
				System.out.println("余额不足！");
			}
		}
	}
}