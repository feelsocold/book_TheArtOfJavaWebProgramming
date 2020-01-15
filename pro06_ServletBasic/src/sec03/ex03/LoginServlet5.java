package sec03.ex03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doHandle(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doHandle(req, resp);
	}
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		
		System.out.println("doHandle() 호출");
		
		String id = req.getParameter("user_id");
		String pwd = req.getParameter("user_pwd");
		String address = req.getParameter("user_address");
		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pwd);
		System.out.println("주소 : " + address);
		
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
