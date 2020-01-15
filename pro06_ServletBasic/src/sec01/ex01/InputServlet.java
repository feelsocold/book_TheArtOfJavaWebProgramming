package sec01.ex01;

import java.io.IOException;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
	
	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		System.out.println("아이디  : " + user_id);
		System.out.println("비밀번호 : " + user_pwd);
		String[] subject = req.getParameterValues("subject");
			
		for (String str : subject) {
			System.out.println("선택한 과목 : " + str);
		}
		
	}
	
	public void destroy() {
		System.out.println("destory 메서드 호출");
	}
	
}
