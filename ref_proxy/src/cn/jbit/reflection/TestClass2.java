package cn.jbit.reflection;
/*
 * �������Class����
 */
public class TestClass2 {	
	public static void main(String[] args) throws ClassNotFoundException {	
		//����1������.getClass()
		Student stu=new Student();
		Class clazz=stu.getClass();			
		String str="Hello World";
		clazz=str.getClass();			
		//����2����.class
		clazz= Student.class;
		clazz=String.class;
		clazz=Integer.class;
		clazz =int.class;
		clazz=int[][].class;		
		//����3��Class.forName()
		clazz=Class.forName("java.lang.String");
		clazz=Class.forName("java.util.Date");		
		//����4����װ��.TYPE
		clazz=Integer.TYPE;
		clazz=Void.TYPE;
	
	}

}
