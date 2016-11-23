package cn.jbit.reflection;

import java.lang.reflect.Constructor;

public class ConstructorTest {
	public static void main(String[] args) throws Exception {

		// //����1������Class��newInstance���������������޲ι��췽��
		// Class clazz=Class.forName("cn.jbit.reflection.Student");
		// Object obj=clazz.newInstance();
		// //Object
		// obj=Class.forName("cn.jbit.reflection.Student").newInstance();

		// ����2������Constructor��newInstance���������������й��췽��
		Class clazz = Class.forName("cn.jbit.reflection.Student");
		Constructor cons = clazz.getConstructor(new Class[] { String.class,
				int.class, float.class });
		Object obj = cons.newInstance(new Object[] { "lkl", 32, 56.5f });
		System.out.println(obj);

		// Ҳ���Ե����޲ι��췽����ֻ�Ǳȷ���1����
		obj = clazz.getConstructor(new Class[] {}).newInstance(new Object[] {});
		obj = clazz.getConstructor().newInstance();
		System.out.println(obj);

	}

}
