package com.jk1205.ctr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jk1205.pojo.TUser;
import com.jk1205.service.UserBiz;

@Controller
public class UserAction {
	
	@Autowired
	private  UserBiz userbiz;
	
	/*
	 *   登录
	 *      参数          账号   密码  验证码
	 *      通讯         session  登录用户
	 *      返回        index.jsp
	 *      作者         老王  
	 */
	@RequestMapping(value="lgn.do",method=RequestMethod.POST )
	public String lgn(TUser user,String code,HttpServletRequest request){
		System.out.println(code);
		TUser usr  =userbiz.login(user);
		//登陸成功
		if(null!=usr){
			request.getSession().setAttribute("user", usr);
			return "redirect:/main.jsp";	
		}
		request.setAttribute("msg", "登錄失敗！");
		return "/index.jsp";
	}
	
	// 登出
	//logoutAction.do
	@RequestMapping("logoutAction.do")
	public String logoutAction(HttpServletRequest request){
		request.getSession().invalidate();
		return "/index.jsp";
	}
}
