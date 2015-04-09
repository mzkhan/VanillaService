package com.markz.testApp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markz.testApp.objects.UserDetail;

@RestController
public class MyTestController {

	@RequestMapping(value="/users/{user}")
	public UserDetail message(@PathVariable String user){
		UserDetail userDetail = new UserDetail();
		userDetail.setAge(21);
		userDetail.setName(user);
		userDetail.setUserId(user+"@markz.com");
		userDetail.setZip(53717);
		
		return userDetail;
	}
}
