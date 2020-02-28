package com.sxt.thread;

/**
 * �����ߺ�������ģʽ���źŵƷ�
 * ������־λ
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

// ����
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
					this.tv.play("�赸");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else  {
				try {
					this.tv.play("���");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
// ����
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

// ����
class Tv {
	String voice;
	// �źŵƣ�true ��ʾ��Ա���ݣ����ڵȴ�; false��ʾ���ڹۿ�����Ա�ȴ�
	boolean flag = true;
	
	public synchronized void play(String voice) throws InterruptedException {
		// ���flagΪfalse������Ա�ȴ�
		if (!flag) {
			this.wait();
		}
		System.out.println("������" + voice);
		this.voice = voice;
		this.notifyAll();
		this.flag = !this.flag;
	}
	
	public synchronized void watch() throws InterruptedException {
		if (flag) {
			this.wait();
		}
		System.out.println("�����ˣ�" + this.voice);
		this.notifyAll();
		this.flag = !this.flag;
	}
}

