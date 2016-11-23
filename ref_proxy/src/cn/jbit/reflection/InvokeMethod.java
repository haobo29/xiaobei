package cn.jbit.reflection;

import java.lang.reflect.Method;

public class InvokeMethod {

	public int add(int x, int y) {
		return x + y;
	}

	public void shout(String name) {
		System.out.println("my name is" + name);
	}

	public static void main(String[] args) throws Exception {
		// 创建该类的一个对象
		Class clazz = InvokeMethod.class;
		Object obj = clazz.newInstance();

		// 调用该对象的add方法
		Method amethod = clazz.getMethod("add", new Class[] { int.class,
				int.class });
		Object result = amethod.invoke(obj, new Object[] { 5, 7 });
		System.out.println(result);

		// 调用该对象的shout方法
		Method smethod = clazz.getMethod("shout", new Class[] { String.class });
		smethod.invoke(obj, new Object[] { "lkl" });

		//相当于如下语句
		// InvokeMethod im=new InvokeMethod();
		// int sum=im.add(5, 7);
		// System.out.println(sum);
		// im.shout("lkl");
	}
}
