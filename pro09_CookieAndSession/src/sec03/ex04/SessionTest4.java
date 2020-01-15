package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login22")
public class SessionTest4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doHandle(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doHandle(req, resp);
	}
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();		// getSession을 호출하여 요청시 세션 객체를 새로 생성하거나 기존 세션을 return;
		
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		
		if(session.isNew()) {
			if(user_id != null || user_id.equals("")) {
				session.setAttribute("user_id", user_id);
				out.println("<a href='login22'>로그인 상태 확인</a>");
			}else {
				out.print("<a href='login.html'>다시 로그인하세요</a>");
				session.invalidate();
			}
		}else {
			user_id = (String)session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {
				out.print("안녕하세요" + user_id + "님!!");
			}else {
				out.print("<a href='login2.html'>다시 로그인하세요!!</a>");
				session.invalidate();
			}
		}
		
		System.out.println("ID : " + user_id);
		
	}
	
}
