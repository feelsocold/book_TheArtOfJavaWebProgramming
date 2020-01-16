package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginImpl implements HttpSessionListener {
	
	String user_id;
	String user_pwd;
	static int total_user = 0;
	
    public LoginImpl() {
    }
    
    public LoginImpl(String user_id, String user_pwd) {
    	this.user_id = user_id;
    	this.user_pwd = user_pwd;
	}

    public void sessionCreated(HttpSessionEvent arg0)  { 	// 세션 생성 시 이벤트를 처리합니다.
    	System.out.println("세션 생성");
    	++total_user;
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 	// 세션 소멸 시 이벤트를 처리합니다.
    	--total_user;
    }
	
}
