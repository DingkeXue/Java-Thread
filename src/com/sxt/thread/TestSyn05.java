package com.sxt.thread;

/**
 * 模拟电影院订座位
 * @author Administrator
 *
 */
public class TestSyn05 {
	public static void main(String[] args) {
		Cinema cinema = new Cinema(10, "科大");
		
		Customer customer = new Customer(cinema, 9);
		Customer customer2 = new Customer(cinema, 9);
		
		new Thread(customer, "顾客一").start();
		new Thread(customer2, "顾客二").start();
		
		
	}
}

// 电影院
class Cinema {
	int avinable;
	String nameString;
	public Cinema(int avinable, String nameString) {
		super();
		this.avinable = avinable;
		this.nameString = nameString;
	}
	
	// 买票
	public boolean bookTickets(int seats) {
		if (avinable > seats) {
			avinable -= seats;
			System.out.println("剩余位置数为：" + avinable);
			return true;
		} else {
			return false;
		}
	}
}

// 顾客
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
			System.out.println("购票成功！"+Thread.currentThread().getName());
		} else {
			System.out.println("购票失败！"+Thread.currentThread().getName());
		}
		}
	}
}

