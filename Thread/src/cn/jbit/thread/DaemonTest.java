package cn.jbit.thread;
public class DaemonTest extends Thread {
	public void run() {
		while (true) {
			System.out.println(getName());
		}
	}

	public static void main(String[] args) {
		DaemonTest dt = new DaemonTest();
		dt.setDaemon(true);
		dt.setName("后台线程");
		dt.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
