package com.sxt.thread;

/**
 * �����Ĳ����ͽ��
 * @author Administrator
 *
 */
public class TestSyn08 {
	public static void main(String[] args) {
		MakeUp make = new MakeUp(0, "��");
		MakeUp make2 = new MakeUp(1, "��");
		
		new Thread(make).start();
		new Thread(make2).start();
		
	}
}

// �ں�
class LipStack {
	
}

// ����
class Mirror {
	
}

class MakeUp implements Runnable {
	static LipStack lipStack = new LipStack();
	static Mirror mirror = new Mirror();
	
	// ѡ��
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
	
	// �໥���жԷ��Ķ������-->���ܻ��������
	public void markup() throws InterruptedException {
		if (choice == 0) {
			// ��Ϳ�ں����վ���
			synchronized (lipStack) {
				System.out.println(this.nameString+"Ϳ�ں�");
				
				Thread.sleep(100);
				
				synchronized (mirror) {
					System.out.println(this.nameString + "�վ���");
				}
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.nameString+"Ϳ�ں�");
				
				Thread.sleep(100);
				
				synchronized (lipStack) {
					System.out.println(this.nameString + "�վ���");
				}
			}
			
		}
	}
	
	// ��������������ͬ������ͬ��
	public void makeup2() throws InterruptedException {
		System.out.println("#####################");
		if (choice == 1) {
			synchronized (lipStack) {
				System.out.println(this.nameString+"Ϳ�ں�");
			}
			Thread.sleep(100);
			synchronized (mirror) {
				System.out.println(this.nameString + "�վ���");
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.nameString + "�վ���");
			} 
			Thread.sleep(100);
			synchronized (lipStack) {
				System.out.println(this.nameString + "Ϳ�ں�");
			}
		}
	}
	
}
