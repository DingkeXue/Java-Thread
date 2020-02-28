package com.sxt.thread;

/**
 * 死锁的产生和解决
 * @author Administrator
 *
 */
public class TestSyn08 {
	public static void main(String[] args) {
		MakeUp make = new MakeUp(0, "我");
		MakeUp make2 = new MakeUp(1, "它");
		
		new Thread(make).start();
		new Thread(make2).start();
		
	}
}

// 口红
class LipStack {
	
}

// 镜子
class Mirror {
	
}

class MakeUp implements Runnable {
	static LipStack lipStack = new LipStack();
	static Mirror mirror = new Mirror();
	
	// 选择
	int choice;
	String nameString;
	public MakeUp(int choice, String nameString) {
		super();
		this.choice = choice;
		this.nameString = nameString;
	}
	
	@Override
	public void run() {
		try {
			//markup();
			makeup2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 相互持有对方的对象的锁-->可能会造成死锁
	public void markup() throws InterruptedException {
		if (choice == 0) {
			// 先涂口红再照镜子
			synchronized (lipStack) {
				System.out.println(this.nameString+"涂口红");
				
				Thread.sleep(100);
				
				synchronized (mirror) {
					System.out.println(this.nameString + "照镜子");
				}
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.nameString+"涂口红");
				
				Thread.sleep(100);
				
				synchronized (lipStack) {
					System.out.println(this.nameString + "照镜子");
				}
			}
			
		}
	}
	
	// 避免死锁：避免同步中套同步
	public void makeup2() throws InterruptedException {
		System.out.println("#####################");
		if (choice == 1) {
			synchronized (lipStack) {
				System.out.println(this.nameString+"涂口红");
			}
			Thread.sleep(100);
			synchronized (mirror) {
				System.out.println(this.nameString + "照镜子");
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.nameString + "照镜子");
			} 
			Thread.sleep(100);
			synchronized (lipStack) {
				System.out.println(this.nameString + "涂口红");
			}
		}
	}
	
}
