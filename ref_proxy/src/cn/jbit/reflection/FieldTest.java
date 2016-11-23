package cn.jbit.reflection;

import java.lang.reflect.Field;

public class FieldTest {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.jbit.reflection.Student");
		Object obj = clazz.newInstance();
		// 调用getDeclaredField("name")方法取得name属性对应的Field对象。
		Field f = clazz.getDeclaredField("name");
		// 取消属性的访问权限控制，即使private属性也可以进行访问。
		f.setAccessible(true);
		// 调用get()方法取得对应属性值。
		System.out.println(f.get(obj));
		// 调用set()方法给对应属性赋值。
		f.set(obj, "lkl");
		// 调用get()方法取得对应属性修改后的值。
		System.out.println(f.get(obj));
	}
}
