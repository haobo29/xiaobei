package cn.jbit.thread;
public class Account {
	// ���
	private int balance = 500;

	// ������
	public int getBalance() {
		return balance;
	}
	// ȡ��
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
