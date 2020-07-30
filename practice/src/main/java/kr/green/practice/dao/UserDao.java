package kr.green.practice.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.practice.vo.UserVo;

public interface UserDao {

	
	UserVo selectSignin(@Param("id")String id);



}
