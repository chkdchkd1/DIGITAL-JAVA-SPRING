package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
	public String getPW(@Param("id")String id);
	public int getCount();
	public int getCheck(String id);
}

