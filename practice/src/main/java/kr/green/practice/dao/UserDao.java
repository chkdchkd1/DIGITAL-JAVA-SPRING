package kr.green.practice.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.practice.vo.UserVo;

public interface UserDao {

	
	UserVo selectSignin(@Param("id")String id);

	void insertUser(@Param("user")UserVo user);

	void updateUser(@Param("user")UserVo user);




}
