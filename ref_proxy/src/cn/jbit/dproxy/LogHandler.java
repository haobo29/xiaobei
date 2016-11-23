package cn.jbit.dproxy;

import java.lang.reflect.*;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	Object target;  //对真实对象的引用

	public LogHandler(Object target) {
		this.target = target;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {	
		if (method.getName().equals("deleteStu")) //对删除操作增加日志操作
			log();
		Object result = method.invoke(target, args); //通过反射调用真实对象的方法
		return result;
	}

	public void log() {
		System.out.println("log before execute");
	}

}
