package cn.jbit.thread;
public class YeildTest {
	public static void main(String[] args) {
		TheThread mt = new TheThread();
		MyNewThread mnt = new MyNewThread();
		mt.start();
		mnt.start();
	}
}
class TheThread extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("��һ���̵߳ĵ� " + (i + 1) + "������");
			Thread.yield();
		}
	}
}
class MyNewThread extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("�ڶ����̵߳ĵ� " + (i + 1) + "������");
			Thread.yield();
		}
	}
}