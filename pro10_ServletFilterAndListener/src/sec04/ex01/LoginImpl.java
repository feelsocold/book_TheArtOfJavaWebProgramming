package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

// 현재 웹 페이지에 로그인한 접속자수를 알아보는 기능을 구현
public class LoginImpl implements HttpSessionBindingListener {
	
	String user_id;
	String user_pwd;
	static int total_user = 0;		// 세션에 바인딩 시 1씩 증가시킵니다.
	
	public LoginImpl() {
		
	}
	
	public LoginImpl(String user_id, String user_pwd) {
		this.user_id = user_id;
		this.user_pwd = user_pwd;
	}
	

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {			// 세션에 저장 시 접속자수를 증가시킵니다.
		System.out.println("사용자 접속");
		++total_user;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {		// 세션에서 소멸 시 접속자 수를 감소시킵니다.
		System.out.println("사용자 접속 해제");
		total_user--;
	}
	
}
