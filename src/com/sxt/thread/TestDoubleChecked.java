package com.sxt.thread;

/**
 * ����ģʽ������ʽ��·�����ϼ��벢�����ƣ���֤���̻߳����£�����ֻ����һ������
 * 1. ������˽�л� ====> Ŀ�ģ������ⲿnew ������
 * 2. �ṩ˽�еľ�̬���� ===> Ŀ�ģ��洢����ĵ�ַ
 * 3. �ṩ�����ľ�̬���� ===> ��ȡ����
 * @author Administrator
 *
 */
public class TestDoubleChecked {
	// ������˽�л�
	private TestDoubleChecked () {};
	// �ṩ˽�о�̬�������洢����ĵ�ַ
	private static volatile TestDoubleChecked instance;
	// �ṩ�����ľ�̬��������ȡ����
	public static TestDoubleChecked getInstance() throws InterruptedException {
		// ���߳��¿��ܴ��ڲ�ͬ������
		synchronized (TestDoubleChecked.class) {
			// ���ܴ��� happenBefore ���⣬���Լ��� volatile
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
