package com.sxt.thread;

/**
 * 单例模式：懒汉式套路基础上加入并发控制，保证多线程环境下，对外只存在一个对象
 * 1. 构造器私有化 ====> 目的：避免外部new 构造器
 * 2. 提供私有的静态属性 ===> 目的：存储对象的地址
 * 3. 提供公共的静态方法 ===> 获取属性
 * @author Administrator
 *
 */
public class TestDoubleChecked {
	// 构造器私有化
	private TestDoubleChecked () {};
	// 提供私有静态属性来存储对象的地址
	private static volatile TestDoubleChecked instance;
	// 提供公共的静态方法来获取属性
	public static TestDoubleChecked getInstance() throws InterruptedException {
		// 多线程下可能存在不同步问题
		synchronized (TestDoubleChecked.class) {
			// 可能存在 happenBefore 问题，所以加上 volatile
			if (instance == null) {
				Thread.sleep(1000);
				instance = new TestDoubleChecked();
			}
		}
		
		return instance;
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(()-> {
			try {
				System.out.println(TestDoubleChecked.getInstance());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		System.out.println(TestDoubleChecked.getInstance());
	}

}
