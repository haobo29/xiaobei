package cn.jbit.reflection;

import java.lang.reflect.*;

public class ArrayTest1 {
	public static void main(String[] args) throws Exception {
		// ����һ������10��Ԫ�ص���������
		Class clazz = Class.forName("java.lang.Integer");
		Object arr = Array.newInstance(clazz, 10);
		// Object arr=Array.newInstance(Integer.TYPE, 10);
		// �������Ԫ�ظ�ֵ
		Array.set(arr, 5, 20);
		// Array.setInt(arr, 5, 20);

		// ȡ�������Ԫ��ֵ�����
		Object elem = Array.get(arr, 5);
		System.out.println(elem);
		//�൱���������
		// int arr[]=new int[10];
		// arr[5]=20;
		// System.out.println(arr[5]);
	}
}
