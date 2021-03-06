package kr.green.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.UserDao;
import kr.green.spring.vo.UserVo;

@Service
public class UserServiceImp implements UserService {
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(UserVo user) {
		if(user == null ) return false;
		if(user.getId() == null || user.getId().length() == 0) return false;
		if(user.getPw() == null || user.getPw().length() == 0) return false;
		if(user.getGender() == null)
			user.setGender("non-set");
		if(!user.getGender().equals("female") && !user.getGender().equals("male") && !user.getGender().equals("non-set") ) return false;
		
		// 아이디가 이미 있는 경우 (중복)
		if(userDao.getUser(user.getId())!=null)
			return false;
		
		// 비밀번호 암호화
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);
		
		// 회원가입 진행 
		userDao.insertUser(user);
		
		return true;
	}

	@Override
	public UserVo isSignin(UserVo user) {
		UserVo dbUser = userDao.getUser(user.getId());
		if(dbUser != null && passwordEncoder.matches(user.getPw(), dbUser.getPw()))
		//passWordEncoder에서 제공하는 matches (입력된 비밀번호(암호화X), 암호화되어 저장된 비밀번호)
			return dbUser;
		return null;
			
	}

	@Override
	public UserVo getUser(HttpServletRequest request) {
		
		return (UserVo)request.getSession().getAttribute("user");
		//가져올땐 UserVo로 가져와야하니까 형변환(?)
	}

	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public void newPw(String id, String newPw) {
		 // 요청한 아이디의 회원 정보를 가져옴
	    UserVo user = getUser(id.trim());
	    // 한단어의 양 끝에 있는 공백을 제거함 trim()
		String encodePW = passwordEncoder.encode(newPw);
		if(user == null)  return ;
		user.setPw(encodePW);
		
		userDao.updatePw(user);
		
		
	}
	

	

}
