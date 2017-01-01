package com.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IUserDao;
import com.entity.User;
@Service
public class UserBizImpl implements IUserBiz {
	@Autowired
	private IUserDao iud;
	
	public User login(String name, String password) {
		User user=iud.queryUserByName(name);
		if(user!=null&&user.getUser_password().equals(password)){
			return user;
		}else{
			
			return null;
		}
	}

}
