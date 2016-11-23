package cn.jbit.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class ClassTest1 {

	public static void main(String[] args) throws Exception {

		/*
		 * 取得某一个类的Class实例，包含着该类的元数据,有多种方法
		 */ 
		// Class<?> clazz = String.class; //方法1
		// Class clazz="abc".getClass();  //方法2
		Class clazz = Class.forName("java.lang.String");//方法3
		
		/*
		 * 从Class中取出对应类的某个或全部字段，并输出其信息
		 */
		// Field fields[]=clazz.getDeclaredFields();
		Field field = clazz.getDeclaredField("count");
		// for(Field field:fields)
		System.out.println(Modifier.toString(field.getModifiers())
				+ field.getName() + field.getType());

		/*
		 * 从Class中取出对应类的某个或全部方法，并输出其信息
		 */ 
		Method methods[] = clazz.getDeclaredMethods();
		// Method methods[]=clazz.getMethods();
		Method method = clazz.getMethod("hashCode", new Class[] {});
		// for(Method method:methods)
		System.out.println(method.getName()
				+ Modifier.toString(method.getModifiers())
				+ method.getReturnType());

		/*
		 * 从Class中取出对应类的某个或全部构造方法，并输出其信息
		 */
		// Constructor constructors[]=clazz.getDeclaredConstructors();
		Constructor constructor = clazz.getDeclaredConstructor(new Class[] {
				char[].class, int.class, int.class });
		// for(Constructor constructor:constructors)
		{
			System.out.print(constructor.getModifiers() + constructor.getName());
			for (Type type : constructor.getParameterTypes()) {
				System.out.print(type + " ");
			}
			System.out.println();
		}
		
		/*
		 * 从Class中取出对应类所在包、类的完整名、简名、父类等信息，判断是不是数组
		 */
		System.out.println(clazz.getPackage().getName());
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getSuperclass());
		clazz=int[].class;
		System.out.println(clazz.isArray());
	}
	
}
