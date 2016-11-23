package cn.jbit.sproxy;
/**
 * 测试类
 */
public class Test {
	public static void main(String[] args) {		
		System.out.println("----不使用静态代理进行操作------");		
		//创建目标类对象，不使用静态代理
		StuManager sm1=new StuManagerImpl();
		//删除指定id学生
		sm1.deleteStu(5);
		//查询指定id学生信息
		System.out.println(sm1.selectStu(5));
		System.out.println("----使用静态代理进行操作------");		
		//创建静态代理类对象
		StuManager sm2=new StuManagerSproxy();
		//删除指定id学生
		sm2.deleteStu(5);
		//查询指定id学生信息
		System.out.println(sm2.selectStu(5));
	}
}
