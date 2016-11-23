package cn.jbit.reflection;

import java.lang.reflect.Constructor;

public class ConstructorTest {
	public static void main(String[] args) throws Exception {

		// //方法1：调用Class的newInstance方法，仅适用于无参构造方法
		// Class clazz=Class.forName("cn.jbit.reflection.Student");
		// Object obj=clazz.newInstance();
		// //Object
		// obj=Class.forName("cn.jbit.reflection.Student").newInstance();

		// 方法2：调用Constructor的newInstance方法，适用于所有构造方法
		Class clazz = Class.forName("cn.jbit.reflection.Student");
		Constructor cons = clazz.getConstructor(new Class[] { String.class,
				int.class, float.class });
		Object obj = cons.newInstance(new Object[] { "lkl", 32, 56.5f });
		System.out.println(obj);

		// 也可以调用无参构造方法，只是比方法1复杂
		obj = clazz.getConstructor(new Class[] {}).newInstance(new Object[] {});
		obj = clazz.getConstructor().newInstance();
		System.out.println(obj);

	}

}
