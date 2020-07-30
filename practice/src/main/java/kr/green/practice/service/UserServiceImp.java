package kr.green.practice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.UserDao;
import kr.green.practice.vo.UserVo;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserVo isSignin(UserVo user) {
		UserVo dbUser = userDao.selectSignin(user.getId());
		if (dbUser != null && user.getPw().equals(dbUser.getPw()) )
			return dbUser;
		return null;
	}

	@Override
	public UserVo getUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return (UserVo)request.getSession().getAttribute("user");
	}

}
