package cn.jbit.reflection;
/*
 * 如何生成Class对象
 */
public class TestClass2 {	
	public static void main(String[] args) throws ClassNotFoundException {	
		//方法1：对象.getClass()
		Student stu=new Student();
		Class clazz=stu.getClass();			
		String str="Hello World";
		clazz=str.getClass();			
		//方法2：类.class
		clazz= Student.class;
		clazz=String.class;
		clazz=Integer.class;
		clazz =int.class;
		clazz=int[][].class;		
		//方法3：Class.forName()
		clazz=Class.forName("java.lang.String");
		clazz=Class.forName("java.util.Date");		
		//方法4：包装类.TYPE
		clazz=Integer.TYPE;
		clazz=Void.TYPE;
	
	}

}
