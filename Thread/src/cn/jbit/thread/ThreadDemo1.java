package cn.jbit.thread;
public class ThreadDemo1 {
	public static void main(String args[]) {
		MyThread1 t = new MyThread1();
		t.start();
		while (true) {
			System.out.println("���������ˣ��𽾰�");
		}
	}
}

class MyThread1 extends Thread {
	public void run() {
		while (true) {
			System.out.println("�ڹ������ˣ�����");
		}
	}
}