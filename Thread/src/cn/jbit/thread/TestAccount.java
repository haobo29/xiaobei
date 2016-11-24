package cn.jbit.thread;
public class TestAccount implements Runnable {
	// ���е��ô�TestAccount���󴴽����̹߳���ͬһ���߳�
	private Account acct = new Account();

	public void run() {
		for (int x = 0; x < 5; x++) {
			// ȡ��
			makeWithdrawal(100);
			if (acct.getBalance() < 0) {
				System.out.println("�˻�͸֧��!");
			}
		}
	}

	private void makeWithdrawal(int amt) {
		synchronized (acct) {
			if (acct.getBalance() >= amt) {
				System.out.println(Thread.currentThread().getName() + " ׼��ȡ��");
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
				}
				// �������㹻����ȡ��
				acct.withdraw(amt);
				System.out.println(Thread.currentThread().getName() + " ���ȡ��");
			} else {
				// ����������ʾ
				System.out.println("������֧�� "
						+ Thread.currentThread().getName() + " ��ȡ����Ϊ "
						+ acct.getBalance());
			}
		}
	}
}
