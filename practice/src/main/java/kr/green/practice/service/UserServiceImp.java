package kr.green.practice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.UserDao;
import kr.green.practice.vo.UserVo;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	//회원 가입 시 암호화가 진행되는 Controller에 BCryptPasswordEncoder 멤버 객체 추가

	@Override
	public UserVo isSignin(UserVo user) {
		UserVo dbUser = userDao.selectSignin(user.getId());
		if (dbUser != null && passwordEncoder.matches(user.getPw(),dbUser.getPw()) )
			// maches 메소드를 이용하여 암호화 되지 않은 비밀번호와 암호화 된 비밀번호를 비교한다. 
			return dbUser;
		return null;
	}

	@Override
	public UserVo getUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return (UserVo)request.getSession().getAttribute("user");
	}

	@Override
	public boolean signUp(UserVo user) {
		// 공백, 또는 잘못된 값이 들어온 경우 false
		if (user == null ) return false;
		if (user.getId() == null || user.getId().length() == 0) return false;
		if (user.getPw() == null || user.getPw().length() == 0) return false;
		if (user.getEmail() == null || user.getEmail().length() == 0 || !user.getEmail().contains("@")) return false;
		
		// 이미 존재하는 회원인지 검사 
		if(userDao.selectSignin(user.getId()) != null ) return false;
		 
		// 비밀번호 암호화 
		String encPw = passwordEncoder.encode(user.getPw());
		user.setPw(encPw);
		 
		// 해당 정보를 DB에 추가 (회원가입)
		userDao.insertUser(user);
		
		return true;	
	}

	@Override
	public UserVo getUser(String id) {
		return userDao.selectSignin(id);
	}

	@Override
	public boolean checkPw(UserVo user, String pw) {
		if(pw == ""||pw == null || passwordEncoder.matches(pw,user.getPw())) {
			//  matches(CharSequence rawPassword, String encodedPassword), 순서 고려! 
			return false;
		} else 
			return true;
	}

	@Override
	public boolean modifyInfo(UserVo user) {
		if (user == null) return false;
		String encPw = passwordEncoder.encode(user.getPw());
		user.setPw(encPw);
		userDao.updateUser(user);		
		return true ;
	}


}
