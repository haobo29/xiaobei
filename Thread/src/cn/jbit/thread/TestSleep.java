package cn.jbit.thread;
public class TestSleep  {
	public static void main(String[] args) {
		System.out.println("Wait");
		// �����̵߳ȴ�5����ִ��
		Wait.bySec(5);
		// ��ʾ�ָ�ִ��
		System.out.println("start");
	}
}

class Wait {
	public static void bySec(long s) {
		// sleep s��1��
		for (int i = 0; i < s; i++) {
			System.out.println(i + 1 + "��");
			try {
				// sleep1��
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
