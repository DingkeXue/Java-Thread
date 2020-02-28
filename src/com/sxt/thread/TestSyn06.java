package com.sxt.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 电影院订票问题：选座
 * @author Administrator
 *
 */
public class TestSyn06 {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		Cinema2 cinema2 = new Cinema2(arrayList, "可达");
		
		List<Integer> seats = new ArrayList<Integer>();
		seats.add(1);
		seats.add(2);
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(2);
		seats2.add(3);
		new Thread(new Customer2(cinema2, seats)).start();
		new Thread(new Customer2(cinema2, seats2)).start();
	}
}

class Cinema2 {
	List<Integer> avilable;
	String nameString;
	
	public Cinema2(List<Integer> avilable, String nameString) {
		super();
		this.avilable = avilable;
		this.nameString = nameString;
	}
	
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("当前可用位置：" + this.avilable);
		List<Integer> copyIntegers = new ArrayList<Integer>();
		copyIntegers.addAll(avilable);
		
		//相减
		copyIntegers.removeAll(seats);
		
		if (avilable.size() - copyIntegers.size() == seats.size()) {
			avilable = copyIntegers;
			return true;
		}
		
		return false;
	}
	
}

class Customer2 implements Runnable {
	Cinema2 cinema;
	List<Integer> seats;
	public Customer2(Cinema2 cinema, List<Integer> seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (cinema) {
			
		boolean flag = this.cinema.bookTickets(this.seats);
		
		if (flag) {
			System.out.println(this.seats+"==>订票成功！还剩："+cinema.avilable);
		} else {
			System.out.println(this.seats+"订票失败！");
			
		}
		}
	}
}
