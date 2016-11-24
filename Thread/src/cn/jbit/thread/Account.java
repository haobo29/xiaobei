package cn.jbit.thread;
public class Account {
	// ”‡∂Ó
	private int balance = 500;

	// ºÏ≤È”‡∂Ó
	public int getBalance() {
		return balance;
	}
	// »°øÓ
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
