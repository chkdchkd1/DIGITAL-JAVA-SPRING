package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.UserDao;
import kr.green.springtest.vo.UserVo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserVo getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public UserVo isUser(UserVo inputUser) {
		/* 일반적으로 로그인 과정은 db에서 아이디와 일치하는 정보를 가져와서 입력받은 아이디와 가져온 정보 중 비밀번호를 비교하여 로그인을 결정한다
		 * => 쿼리로 비밀번호를 비교하지 않는다
		 * => 입력한 비밀번호는 실제 비밀번호이고 .db에 저장된 비밀번호는 암호화된 비밀번호 이기때문에 쿼리로 직접 비교할 수 없다
		 * => 다른이유로는 pw에 이상한 작업을 하면 로그인이 될 수 있기 때문에 (블라인드 SQL 인젝션 )
		 * => == / equals() : equals 객체끼리 비교 , 대상 내용 자체를 비교 / == 는 대상의 주소값을 비교 , 연산자  */
		UserVo user = userDao.getUser(inputUser.getId());
		if(user == null)
			return null;
		if(user.getPw().equals(inputUser.getPw())){
				return user;
		}	
		return null;
	}

}
