package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pwd);
		
		String data= "<html>";
		data += "<body>";
		
		if(user_id != null && (user_id.length()!=0)) {
			 data += "<bold>"+user_id + "</bold>님 환영합니다!";
			 data += "</body></html>";
			 
			 out.print(data);
		}else {
			data += "아이디를 입력하세요!";
			data += "<br>";
			data += "<a href='http://localhost:8090/pro06/test01/login.html'>";
			data += "</body></html>";
			
			out.print(data);
		}
	}
	
}
