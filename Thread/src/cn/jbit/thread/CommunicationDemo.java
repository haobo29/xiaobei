package cn.jbit.thread;
class SharedData{
	private char c;
	private boolean isProduced = false; // �ź���
	// ͬ������putShareChar()
	public synchronized void putShareChar(char c) {
		// �����Ʒ��δ���ѣ��������ߵȴ�
		if (isProduced) {
			try{
				System.out.println("�����߻�δ���ѣ����������ֹͣ����");
				wait(); // �����ߵȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.c = c;
		isProduced = true; // ����Ѿ�����
		notify(); // ֪ͨ�������Ѿ���������������
		System.out.println("�����˲�Ʒ" + c + "  ֪ͨ����������...");
	}
	// ͬ������getShareChar()
	public synchronized char getShareChar() {
		// �����Ʒ��δ�������������ߵȴ�
		if (!isProduced){
			try{
				System.out.println("�����߻�δ���������������ֹͣ����");
				wait(); // �����ߵȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isProduced = false; // ����Ѿ�����
		notify(); // ֪ͨ��Ҫ����
		System.out.println("�����������˲�Ʒ" + c + "  ֪ͨ����������...");
		return this.c;
	}
}

//�������߳�
class Producer extends Thread {
	private SharedData s;
	Producer(SharedData s){
		this.s = s;
	}
	public void run(){
		for (char ch = 'A'; ch <= 'D'; ch++){
			try{
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.putShareChar(ch); // ����Ʒ����ֿ�
		}
	}
}
//�������߳�
class Consumer extends Thread {
	private SharedData s;
	Consumer(SharedData s){
		this.s = s;
	}
	public void run(){
		char ch;
		do {
			try	{
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ch = s.getShareChar(); // �Ӳֿ���ȡ����Ʒ
		} while (ch != 'D');
	}
}
//������
class CommunicationDemo{
	public static void main(String[] args){
		//����ͬһ��������Դ
		SharedData s = new SharedData();
		//�������߳�
		new Consumer(s).start();
		//�������߳�
		new Producer(s).start();
	}
}
