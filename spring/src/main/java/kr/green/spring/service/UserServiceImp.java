package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.UserDao;

@Service
public class UserServiceImp implements UserService {
	
	
	@Autowired
	private UserDao userDao;

	@Override
	public String getPW(String id) {
		if(userDao.getPW(id) == null)
			return "존재하지 않는 아이디입니다";
		return userDao.getPW(id);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return userDao.getCount();
	}

	@Override
	public String getCheck(String id) {
		if ( userDao.getCheck(id) == 0 )
			return "가입기록 없음";
		return "이미 가입함";
		
	}

}
