package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrgDaoUtil {
	public Connection getCn(){
		Connection cn=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	public void freeRes(Connection cn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(cn!=null){
				cn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
