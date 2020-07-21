package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, 
			//prehandle 가기전에 가로채고 return false면 해당 controller로 안가고 return true면 해당 controller로 간다 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		return true;
	}
	
	
//	응답이 이미 커밋된 후에는 sendredirect()를 호출할 수 없습니다 :
// user 가 null인경우에 return 처리를 안해줘서 return true 로 가게 되고 컨트롤러 갔기 때문에 발생한 오류 
// -> null인경우 return false처리를 해준다 .
//	
//	preHandle 메소드 오버라이딩
//	세션에 user 정보를 가져와서 null값이면 로그인 화면으로 보냄
//	정보가 있으면 그냥 넘어감
}
