package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login90")
public class LoginTest extends HttpServlet {
	
	ServletContext context = null;
	List<String> user_list = new ArrayList<String>();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	
		context = getServletContext();
		
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);		// LoginImpl 객체를 생성한 후 전송된 Id와 비밀번호를 저장합니다
		
		
		// 최초 로그인 시 접속자 ID를 ArrayList에 차례로 저장 후 다시 context 개체에 속성으로 저장합니다.
		if(session.isNew()) {										
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
	
		out.println("<html><body>");
		out.println("아이디 : " + loginUser.user_id + "<br>");
		out.println("총 접속자수 : " + LoginImpl.total_user + "<br>");
		out.println("접속 아이디 : " + "<br>");
		List list = (ArrayList)context.getAttribute("user_list");
		
		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i)+"<br>");
		}
		out.println("<a href='logout?user_id="+user_id+"'>로그아웃</a>");
		out.println("</body></html>");
		
	}
	
}
