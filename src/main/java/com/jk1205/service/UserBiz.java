package com.jk1205.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.jk1205.pojo.TUser;

@Component
public interface UserBiz {

	TUser login(TUser user);

	boolean batchImport(String fileName, MultipartFile actfile);

}
