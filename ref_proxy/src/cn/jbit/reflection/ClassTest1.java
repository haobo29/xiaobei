package cn.jbit.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class ClassTest1 {

	public static void main(String[] args) throws Exception {

		/*
		 * ȡ��ĳһ�����Classʵ���������Ÿ����Ԫ����,�ж��ַ���
		 */ 
		// Class<?> clazz = String.class; //����1
		// Class clazz="abc".getClass();  //����2
		Class clazz = Class.forName("java.lang.String");//����3
		
		/*
		 * ��Class��ȡ����Ӧ���ĳ����ȫ���ֶΣ����������Ϣ
		 */
		// Field fields[]=clazz.getDeclaredFields();
		Field field = clazz.getDeclaredField("count");
		// for(Field field:fields)
		System.out.println(Modifier.toString(field.getModifiers())
				+ field.getName() + field.getType());

		/*
		 * ��Class��ȡ����Ӧ���ĳ����ȫ�����������������Ϣ
		 */ 
		Method methods[] = clazz.getDeclaredMethods();
		// Method methods[]=clazz.getMethods();
		Method method = clazz.getMethod("hashCode", new Class[] {});
		// for(Method method:methods)
		System.out.println(method.getName()
				+ Modifier.toString(method.getModifiers())
				+ method.getReturnType());

		/*
		 * ��Class��ȡ����Ӧ���ĳ����ȫ�����췽�������������Ϣ
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
		 * ��Class��ȡ����Ӧ�����ڰ���������������������������Ϣ���ж��ǲ�������
		 */
		System.out.println(clazz.getPackage().getName());
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getSuperclass());
		clazz=int[].class;
		System.out.println(clazz.isArray());
	}
	
}
