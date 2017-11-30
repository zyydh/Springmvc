package com.jk1205.ctr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import com.jk1205.pojo.TUser;
import com.jk1205.service.IUserBiz;
import com.jk1205.service.UserBiz;


@Controller
public class UploadAction {
	
	   @Autowired
	   private  UserBiz iuserS;
	
	    @RequestMapping("upload.do")
	    public String upload(MultipartFile actfile,HttpServletRequest req){
	    	
	    	TUser user= (TUser) req.getSession().getAttribute("user");
	    		
	    	//���²�   ����  ���� boss  ����¼��
	    	if(user.getGid()==2||user.getAid()==1||user.getAid()==3){
	    		
	    		
	    		if(actfile!=null){
	    			//�ļ���
	    			  String  fileName=actfile.getOriginalFilename();
	    			//           �����������                               �ļ���              �ļ�ʵ��
	    			  boolean b=iuserS.batchImport(fileName,actfile);
	    			  
	    			  if(b){
	    				  req.setAttribute("msg", "�ϴ��ɹ�");
	    			  }else{
	    				  req.setAttribute("msg", "�ϴ�err");
	    			  }
	    			  
	    			
	    		}
	    		
	    		
	    	}
	    	
	    	
			return "/upload.jsp";
	    }

}
