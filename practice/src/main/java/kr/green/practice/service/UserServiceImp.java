package kr.green.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.practice.dao.UserDao;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public String getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

}
