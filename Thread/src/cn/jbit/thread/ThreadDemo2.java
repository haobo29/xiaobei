package cn.jbit.thread;
public class ThreadDemo2 {
	public static void main(String args[]) {
		MyThread2 mt = new MyThread2();
		Thread t = new Thread(mt);
		t.start();
		while (true) {
			System.out.println("���������ˣ�����");
		}
	}
}

class MyThread2 implements Runnable {
	public void run() {
		while (true) {
			System.out.println("�ڹ곬���ˣ��ٽ�����");
		}
	}
}
