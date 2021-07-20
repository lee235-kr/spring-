package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session =request.getSession(false);
		if(session != null) {
			Object authInfo =session.getAttribute("authInfo");
			if(authInfo != null) return true;
		}
		response.sendRedirect(request.getContextPath()+"/");
		return false;
		
	}
	///컨트롤러에 진입 후 view가 랜더링하기 전에 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}
	//컨트롤러에 진입 후 view까지 정상적으로 랜더링한후
 @Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {

	super.afterCompletion(request, response, handler, ex);
}
 
}
