package cn.jbit.thread;
public class TestWithdrawal {
	public static void main(String[] args) {
		// 创建两个线程分别表示张三和张三的老婆
		TestAccount r = new TestAccount();
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("张三");
		two.setName("张三的妻子");
		one.start();
		two.start();
	}
}
