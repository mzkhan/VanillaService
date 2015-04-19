package com.markz.testApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markz.testApp.mappers.UserDetailsMapper;
import com.markz.testApp.objects.UserDetail;

@RestController
public class MyTestController {

	private static final Logger LOGGER = Logger
			.getLogger(MyTestController.class);

	@Autowired
	UserDetailsMapper userDetailsMapper;

	@RequestMapping(value = "/users/{id}")
	public UserDetail getUserById(@PathVariable int id) {
		LOGGER.info("ID: " + id);
		return userDetailsMapper.getUserDetail(id);
	}

	@RequestMapping(value = "/users")
	public List<UserDetail> userList() {
		LOGGER.info("Request for All the users");
		return userDetailsMapper.getAllUsers();
	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public void createUser(@RequestBody UserDetail userDetail,
			HttpServletResponse httpServletResponse) {
		LOGGER.info("Creating User with Name = " + userDetail.getName()
				+ " Age: " + userDetail.getAge() + " User_id = "
				+ userDetail.getUserId() + " zip = " + userDetail.getZip());
		try {
			userDetailsMapper.createUser(userDetail);
			httpServletResponse.setStatus(HttpStatus.CREATED.value());
		} catch (Exception e) {
			httpServletResponse
					.setStatus(HttpStatus.EXPECTATION_FAILED.value());
		}
	}

	@RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT)
	public UserDetail updateUser(@RequestBody UserDetail userDetail,
			@PathVariable int id, HttpServletResponse httpServletResponse, 
			AuthenticationException authException) {
		LOGGER.info("Updating the user with id: " + id);

		try {
			userDetailsMapper.updateUser(userDetail);
			httpServletResponse.setStatus(HttpStatus.OK.value());
		} catch (Exception e) {
			httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		}
		return userDetailsMapper.getUserDetail(id);

	}

}
