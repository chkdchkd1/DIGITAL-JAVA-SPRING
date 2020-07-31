package kr.green.practice.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.practice.vo.UserVo;

public interface UserService {

	UserVo isSignin(UserVo user);

	UserVo getUser(HttpServletRequest request);

	boolean signUp(UserVo user);

	UserVo getUser(String id);

	boolean checkPw(UserVo user, String pw);

	boolean modifyInfo(UserVo user);

}
