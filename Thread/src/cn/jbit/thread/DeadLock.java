package cn.jbit.thread;

public class DeadLock implements Runnable {
	public boolean temp = true;
	public Object object=new Object();
	@Override
	public void run() {
		System.out.println(temp);
		if (temp) {
			method1();
		} else {
			method2();
		}
	}

	public synchronized void method1() {
		System.out.println("���this�����ȴ�object��������");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (object) {
			System.out.println("---------method1------------");
		}
	}

	public void method2() {
		synchronized (object) {
			System.out.println("���object�����ȴ�this��������");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {
				System.out.println("---------method2------------");
			}
		}
	}
	
	public static void main(String[] args) {
		DeadLock dl=new DeadLock();
		Thread t1=new Thread(dl);
		t1.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dl.temp=false;
		Thread t2=new Thread(dl);
		t2.start();
	}

}
