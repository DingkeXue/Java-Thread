package com.sxt.thread;

/**
 * 
 * @author Administrator
 * ͬһʱ��ȡǮ�����⣺����ȫ��û������
 *
 */
public class TestSyn02 {
	public static void main(String[] args) {
		Account account = new Account(100, "��Ǯ");
		Drawing drawing = new Drawing(account, 90, "��");
		Drawing drawing2 = new Drawing(account, 90, "��");
		new Thread(drawing).start();
		new Thread(drawing2).start();
	}
}

// �˻�
class Account {
	int money;
	String nameString;
	
	public Account(int money, String nameString) {
		super();
		this.money = money;
		this.nameString = nameString;
	}
}

// ȡǮ
class Drawing implements Runnable {
	private Account account;
	private int getMoney;
	private String nameString;
	
	public Drawing(Account account, int getMoney, String name) {
		super();
		this.account = account;
		this.getMoney = getMoney;
		this.nameString = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (this.account.money > getMoney) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.account.money -= getMoney;
			System.out.println("ȡǮ�ɹ�����" + this.account.money);
		} else {
			System.out.println("���㣡");
		}
	}
}

