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
		// ���������һ������
		Class clazz = InvokeMethod.class;
		Object obj = clazz.newInstance();

		// ���øö����add����
		Method amethod = clazz.getMethod("add", new Class[] { int.class,
				int.class });
		Object result = amethod.invoke(obj, new Object[] { 5, 7 });
		System.out.println(result);

		// ���øö����shout����
		Method smethod = clazz.getMethod("shout", new Class[] { String.class });
		smethod.invoke(obj, new Object[] { "lkl" });

		//�൱���������
		// InvokeMethod im=new InvokeMethod();
		// int sum=im.add(5, 7);
		// System.out.println(sum);
		// im.shout("lkl");
	}
}
