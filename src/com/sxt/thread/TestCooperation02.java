package com.sxt.thread;

/**
 * 生产者和消费者模式：信号灯法
 * 借助标志位
 * @author Administrator
 *
 */
public class TestCooperation02 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		new Thread(new Player(tv)).start();
		new Thread(new Watcher(tv)).start();
	}
}

// 表演
class Player extends Thread {
	Tv tv;

	public Player(Tv tv) {
		super();
		this.tv = tv;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if ((i%2) == 0) {
				try {
					this.tv.play("舞蹈");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else  {
				try {
					this.tv.play("广告");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
// 观众
class Watcher extends Thread {
	Tv tv;

	public Watcher(Tv tv) {
		super();
		this.tv = tv;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				this.tv.watch();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

// 电视
class Tv {
	String voice;
	// 信号灯：true 表示演员表演，观众等待; false表示观众观看，演员等待
	boolean flag = true;
	
	public synchronized void play(String voice) throws InterruptedException {
		// 如果flag为false，则演员等待
		if (!flag) {
			this.wait();
		}
		System.out.println("表演了" + voice);
		this.voice = voice;
		this.notifyAll();
		this.flag = !this.flag;
	}
	
	public synchronized void watch() throws InterruptedException {
		if (flag) {
			this.wait();
		}
		System.out.println("听到了：" + this.voice);
		this.notifyAll();
		this.flag = !this.flag;
	}
}

