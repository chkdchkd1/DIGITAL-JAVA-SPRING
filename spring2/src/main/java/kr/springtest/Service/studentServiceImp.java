package kr.springtest.Service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.green.springtest.dao.studentDAO;

public class studentServiceImp implements studentService {

	@Autowired
	studentDAO studentdao;
	
	@Override
	public String getName(String num) {
		// TODO Auto-generated method stub
		return studentdao.getName(num);
	}

}
