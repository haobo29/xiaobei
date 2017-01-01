package com.dao;

import com.entity.User;

public interface IUserDao {
	public User queryUserByName(String name);
}
