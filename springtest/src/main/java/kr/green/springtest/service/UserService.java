package kr.green.springtest.service;

import kr.green.springtest.vo.UserVo;

public interface UserService {

	UserVo getUser(String id);

	boolean signup(UserVo user);

	UserVo isSignin(UserVo user);

}
