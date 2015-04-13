package com.markz.testApp.mappers;

import java.util.List;

import com.markz.testApp.objects.UserDetail;

//@Configuration
public interface UserDetailsMapper {
	public List<UserDetail> getAllUsers();
	
	public UserDetail getUserDetail(int id);
	
	public UserDetail getUserDetailByLoginId(String loginId);
	
	public void createUser(UserDetail userDetail);
	
	public void updateUser(UserDetail userDetail);
}
