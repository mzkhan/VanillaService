package com.markz.testApp.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.markz.testApp.objects.UserDetail;

public class UserDetailDao extends SqlSessionDaoSupport {

	public List<UserDetail> getAllUsers() {
		return getSqlSession().selectList("getAllUsers");
	}

	public UserDetail getUserDetails(int id) {
		return getSqlSession().selectOne("getgetUserDetail");
	}
}
