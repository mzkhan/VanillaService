package com.markz.testApp.mappers;

import java.util.List;

import com.markz.testApp.objects.UserDetail;

//@Configuration
public interface UserDetailsMapper {
	public List<UserDetail> getAllUsers();
	
//	@Select("SELECT * FROM user_detail where user_id={#userId}")
	public UserDetail getUserDetail(int id);
	
	public UserDetail getUserDetailByLoginId(String loginId);
	
//	public int insertUserDetail(UserDetail userDetail);
	
//	public void updateUserDetail(UserDetail userDetail);
}
