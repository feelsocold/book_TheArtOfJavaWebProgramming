package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet extends HttpServlet {
	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//req.setCharacterEncoding("utf-8");
		//resp.setCharacterEncoding("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		String user_address = req.getParameter("user_address");
		String user_email = req.getParameter("user_email");
		String user_hp = req.getParameter("user_hp");
		
		String data= "<html>";
		 data +="<body>";
		 data += "<bold>"+user_id + "</bold>님 환영합니다!<br>";
		 data += "아이디 : " + user_id + "<br>비밀번호 : " + user_pwd + "<br>연락처 : " + user_hp;
		 
		 out.print(data);
		 
		 user_address=URLEncoder.encode(user_address,"utf-8");
		 out.print("<br><a href='/pro09/second?user_id="+user_id+"&user_pw="+user_pwd+"'>두번째 서블릿으로 보내기</a>");
		
		 data = "</body></html>";
		 out.print(data);
		
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
