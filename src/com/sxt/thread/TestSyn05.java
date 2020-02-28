package com.sxt.thread;

/**
 * ģ���ӰԺ����λ
 * @author Administrator
 *
 */
public class TestSyn05 {
	public static void main(String[] args) {
		Cinema cinema = new Cinema(10, "�ƴ�");
		
		Customer customer = new Customer(cinema, 9);
		Customer customer2 = new Customer(cinema, 9);
		
		new Thread(customer, "�˿�һ").start();
		new Thread(customer2, "�˿Ͷ�").start();
		
		
	}
}

// ��ӰԺ
class Cinema {
	int avinable;
	String nameString;
	public Cinema(int avinable, String nameString) {
		super();
		this.avinable = avinable;
		this.nameString = nameString;
	}
	
	// ��Ʊ
	public boolean bookTickets(int seats) {
		if (avinable > seats) {
			avinable -= seats;
			System.out.println("ʣ��λ����Ϊ��" + avinable);
			return true;
		} else {
			return false;
		}
	}
}

// �˿�
class Customer implements Runnable {
	Cinema cinema;
	int seats;
	
	public Customer(Cinema cinema, int seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (cinema) {
			
		boolean flag = this.cinema.bookTickets(seats);
		if (flag) {
			System.out.println("��Ʊ�ɹ���"+Thread.currentThread().getName());
		} else {
			System.out.println("��Ʊʧ�ܣ�"+Thread.currentThread().getName());
		}
		}
	}
}

