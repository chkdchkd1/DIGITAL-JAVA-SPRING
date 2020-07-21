package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Authloginterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, 
			//prehandle 가기전에 가로채고 return false면 해당 controller로 안가고 return true면 해당 controller로 간다 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		if(user != null) {
			response.sendRedirect(request.getContextPath()+"/board/list");
			return false;
		}
		return true;
	}
	
}
