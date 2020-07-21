package kr.green.springtest.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.springtest.vo.UserVo;

public interface UserService {

	UserVo getUser(HttpServletRequest request);

	boolean signup(UserVo user);

	UserVo isSignin(UserVo user);

}
