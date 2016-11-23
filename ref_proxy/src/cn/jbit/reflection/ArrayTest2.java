package cn.jbit.reflection;

import java.lang.reflect.*;

public class ArrayTest2 {

	public static void main(String[] args) throws Exception {
		// int arr[][][]=new int[10][15][18];
		// arr[5][8][10]=20;
		// System.out.println(arr[5][8][10]);

		// 创建一个含有10*15*18个元素的整型数组
		int dims[] = { 10, 15, 18 };
		Object arr = Array.newInstance(int.class, dims);
//		Class arrClass = arr.getClass();
//		System.out.println(arrClass.getName() + "  "
//				+ arrClass.getComponentType());

		// 给arr[5][8][10]赋值
		Object arr5 = Array.get(arr, 5);

//		Class arr5Class = arr5.getClass();
//		System.out.println(arr5Class.getName() + "  "
//				+ arr5Class.getComponentType());

		Object arr58 = Array.get(arr5, 8);
//		Class arr58Class = arr58.getClass();
//		System.out.println(arr58Class.getName() + "  "
//				+ arr58Class.getComponentType());

		Array.set(arr58, 10, 30);

		// 取出arr[5][8][10]值并输出
		Object elem = Array.get(arr58, 10);
		System.out.println(elem);
//		Class elemClass = elem.getClass();
//		System.out.println(elemClass.getName() + "   "
//				+ elemClass.getComponentType());
		int[][][] arr2 = (int[][][]) arr;
		System.out.println(arr2[5][8][10]);
	}
}
