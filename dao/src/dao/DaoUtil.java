package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtil {
	Connection cn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public void setConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://ThinkPad:3306/exercise", "root", "lh1212");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int doDml(String sql,Object[] objs){
		int count=-1;
		try {
			setConnection();
			ps=cn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			count=ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			freeResource();
		}
		return count;
	}
	public void freeResource(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if (cn!=null) {
				cn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
