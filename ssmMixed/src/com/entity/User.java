package com.entity;

public class User {
	private int user_id;
    private String user_name;
    private String user_password;
    private String user_sex;
    private int user_age;
    private String user_tel;
    private String user_address;
    private int user_role;
    
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String userSex) {
		user_sex = userSex;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int userAge) {
		user_age = userAge;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String userTel) {
		user_tel = userTel;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String userAddress) {
		user_address = userAddress;
	}
	public int getUser_role() {
		return user_role;
	}
	public void setUser_role(int userRole) {
		user_role = userRole;
	}
	public User(int userId, String userName, String userPassword,
			String userSex, int userAge, String userTel, String userAddress,
			int userRole) {
		super();
		user_id = userId;
		user_name = userName;
		user_password = userPassword;
		user_sex = userSex;
		user_age = userAge;
		user_tel = userTel;
		user_address = userAddress;
		user_role = userRole;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
