package cn.jbit.dproxy;

import java.lang.reflect.*;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	Object target;  //����ʵ���������

	public LogHandler(Object target) {
		this.target = target;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {	
		if (method.getName().equals("deleteStu")) //��ɾ������������־����
			log();
		Object result = method.invoke(target, args); //ͨ�����������ʵ����ķ���
		return result;
	}

	public void log() {
		System.out.println("log before execute");
	}

}
