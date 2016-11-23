package cn.jbit.reflection;

import java.lang.reflect.Field;

public class FieldTest {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.jbit.reflection.Student");
		Object obj = clazz.newInstance();
		// ����getDeclaredField("name")����ȡ��name���Զ�Ӧ��Field����
		Field f = clazz.getDeclaredField("name");
		// ȡ�����Եķ���Ȩ�޿��ƣ���ʹprivate����Ҳ���Խ��з��ʡ�
		f.setAccessible(true);
		// ����get()����ȡ�ö�Ӧ����ֵ��
		System.out.println(f.get(obj));
		// ����set()��������Ӧ���Ը�ֵ��
		f.set(obj, "lkl");
		// ����get()����ȡ�ö�Ӧ�����޸ĺ��ֵ��
		System.out.println(f.get(obj));
	}
}
