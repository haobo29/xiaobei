package cn.jbit.dproxy;

import java.lang.reflect.*;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-------�����ö�̬����--------");
		StuManager stuManager=new StuManagerImpl();
		stuManager.deleteStu(4);	
		System.out.println(stuManager.selectStu(5));
		System.out.println("-------���ö�̬����--------");
		LogHandler lh=new LogHandler(stuManager);
		StuManager up=(StuManager)lh.getProxy();
		up.deleteStu(4);
		System.out.println(up.selectStu(5));
  
	}

}
