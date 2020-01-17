package sec00;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sTest")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();		// getSession을 호출하여 요청시 세션 객체를 새로 생성하거나 기존 세션을 return;
		
		String user = (String)session.getAttribute("user");
		System.out.println(user);
		
		
		String url = resp.encodeURL("sTest");
		System.out.println("URL : " + url);
		
		out.println("encodeURL : " + url + "<br>");
		out.println("세션 아이디 : " + session.getId() + "<br>");
		out.println("최초 세션 생성 시작 : " + new Date(session.getCreationTime()) + "<br>");
		out.println("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");
		
		out.println("기본 세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
	//	session.setMaxInactiveInterval(5);
	//	out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		
		if(session.isNew()) {					// 최초 생성된 세션인지 판단
			out.print("새로운 세션이 생성되었습니다.");
		}
	
	}
	
}
