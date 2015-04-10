package com.markz.testApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markz.testApp.mappers.UserDetailsMapper;
import com.markz.testApp.objects.UserDetail;

@RestController
public class MyTestController {

	@Autowired
	UserDetailsMapper userDetailsMapper;

	@RequestMapping(value = "/users/{id}")
	public UserDetail getUserById(@PathVariable int id) {
		return userDetailsMapper.getUserDetail(id);
	}

	@RequestMapping(value = "/users")
	public List<UserDetail> userList() {
		return userDetailsMapper.getAllUsers();
	}

}
