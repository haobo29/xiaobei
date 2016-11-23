package cn.jbit.reflection;

import java.lang.reflect.*;

public class ArrayTest1 {
	public static void main(String[] args) throws Exception {
		// 创建一个含有10个元素的整型数组
		Class clazz = Class.forName("java.lang.Integer");
		Object arr = Array.newInstance(clazz, 10);
		// Object arr=Array.newInstance(Integer.TYPE, 10);
		// 给第五个元素赋值
		Array.set(arr, 5, 20);
		// Array.setInt(arr, 5, 20);

		// 取出第五个元素值并输出
		Object elem = Array.get(arr, 5);
		System.out.println(elem);
		//相当于如下语句
		// int arr[]=new int[10];
		// arr[5]=20;
		// System.out.println(arr[5]);
	}
}
