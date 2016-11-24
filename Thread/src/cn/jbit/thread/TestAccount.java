package cn.jbit.thread;
public class TestAccount implements Runnable {
	// 所有的用此TestAccount对象创建的线程共享同一个线程
	private Account acct = new Account();

	public void run() {
		for (int x = 0; x < 5; x++) {
			// 取款
			makeWithdrawal(100);
			if (acct.getBalance() < 0) {
				System.out.println("账户透支了!");
			}
		}
	}

	private void makeWithdrawal(int amt) {
		synchronized (acct) {
			if (acct.getBalance() >= amt) {
				System.out.println(Thread.currentThread().getName() + " 准备取款");
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}
				// 如果余额足够，则取款
				acct.withdraw(amt);
				System.out.println(Thread.currentThread().getName() + " 完成取款");
			} else {
				// 余额不够给出提示
				System.out.println("余额不足以支付 "
						+ Thread.currentThread().getName() + " 的取款，余额为 "
						+ acct.getBalance());
			}
		}
	}
}
