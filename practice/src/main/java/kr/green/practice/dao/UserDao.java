package kr.green.practice.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {

	String getUser(@Param("id")String id);



}
