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
		System.out.println("获得this锁，等待object锁！！！");
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
			System.out.println("获得object锁，等待this锁！！！");
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
