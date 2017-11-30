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
	 *   ��¼
	 *      ����          �˺�   ����  ��֤��
	 *      ͨѶ         session  ��¼�û�
	 *      ����        index.jsp
	 *      ����         ����  
	 */
	@RequestMapping(value="lgn.do",method=RequestMethod.POST )
	public String lgn(TUser user,String code,HttpServletRequest request){
		System.out.println(code);
		TUser usr  =userbiz.login(user);
		//��ꑳɹ�
		if(null!=usr){
			request.getSession().setAttribute("user", usr);
			return "redirect:/main.jsp";	
		}
		request.setAttribute("msg", "���ʧ����");
		return "/index.jsp";
	}
	
	// �ǳ�
	//logoutAction.do
	@RequestMapping("logoutAction.do")
	public String logoutAction(HttpServletRequest request){
		request.getSession().invalidate();
		return "/index.jsp";
	}
}
