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
	    		
	    	//人事部   经理  或者 boss  可以录入
	    	if(user.getGid()==2||user.getAid()==1||user.getAid()==3){
	    		
	    		
	    		if(actfile!=null){
	    			//文件名
	    			  String  fileName=actfile.getOriginalFilename();
	    			//           传入解析方法                               文件名              文件实体
	    			  boolean b=iuserS.batchImport(fileName,actfile);
	    			  
	    			  if(b){
	    				  req.setAttribute("msg", "上传成功");
	    			  }else{
	    				  req.setAttribute("msg", "上传err");
	    			  }
	    			  
	    			
	    		}
	    		
	    		
	    	}
	    	
	    	
			return "/upload.jsp";
	    }

}
