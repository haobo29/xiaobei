package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.biz.IUserBiz;
import com.entity.User;

public class UserController extends MultiActionController{
	@Autowired
	private IUserBiz userBiz;
	
	
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		User user=userBiz.login(name, password);
		ModelAndView mav=new ModelAndView();
		
		if(user!=null){
			mav.addObject("message", "µÇÂ½³É¹¦");
		}else{
			mav.addObject("message", "µÇÂ¼Ê§°Ü");
		}
		mav.setViewName("result.jsp");
		return mav;
	}
}
