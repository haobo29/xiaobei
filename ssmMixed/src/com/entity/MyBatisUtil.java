package com.entity;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private MyBatisUtil(){
	}
	private static final String RESOURCE = "SqlMapConfig.xml";
	private static SqlSessionFactory sqlSessionFactory = null;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder.build(reader);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ExceptionInInitializerError("初始化MyBatis错误，请�?��配置文件或数据库");
			
		}
	}
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	public static SqlSession getSession(){
		
		SqlSession session = threadLocal.get();
		
		if (session == null){
			session = (sqlSessionFactory !=null) ?sqlSessionFactory.openSession():null;
			threadLocal.set(session); // 5
		}
		return session;
	}
	public static void closeSession(){
		SqlSession session = (SqlSession) threadLocal.get(); // 2
		threadLocal.set(null);
		if (session !=null){
			session.close();
		}
	}
}
