package dao.impl;

import dao.DaoUtil;
import dao.StudentDao;
import entity.Student;

public class StudentDaoImpl extends DaoUtil implements StudentDao{

	@Override
	public int addStudent(Student stu) {
		// TODO Auto-generated method stub
		String sql="insert into student values(default,?,?,?)";
		Object[] objs=new Object[]{stu.getName(),stu.getAge(),stu.getGender()};
		int count=doDml(sql, objs);
		return count;
	}
	public static void main(String[] args) {
		StudentDao sd=new StudentDaoImpl();
		Student stu=new Student(0, "zhangsan", 10, "男");
		int count=sd.addStudent(stu);
		System.out.println(count);
	}
}
