package cn.jbit.thread;
public class TestWithdrawal {
	public static void main(String[] args) {
		// ���������̷ֱ߳��ʾ����������������
		TestAccount r = new TestAccount();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("����");
		two.setName("����������");
		one.start();
		two.start();
	}
}
