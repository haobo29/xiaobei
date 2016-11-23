package cn.jbit.reflection;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class WhyClass {
	
	public void method1(Student stu1) {
		Student stu2 = new Student();

		stu2.name = "lkl";
		stu2.setAge(stu1.getAge());

		System.out.println(stu2.name);
		System.out.println(stu2.getAge());
	}

	public void method2(String str) throws Exception {
		// ??????如何创建对象，如何执行方法，如何对属性进行操作
		// !!!!!此时可以使用Java反射技术
		Class clazz = Class.forName(str);
		Object obj = clazz.newInstance();
		Field[] fs = clazz.getFields();
		Method[] ms = clazz.getMethods();

	}

	public static void main(String[] args) throws Exception {
		WhyClass t = new WhyClass();
		t.method2("java.lang.String");
		t.method2("cn.jbit.reflection.Student");
		t.method2("java.util.Date");
	}
}
