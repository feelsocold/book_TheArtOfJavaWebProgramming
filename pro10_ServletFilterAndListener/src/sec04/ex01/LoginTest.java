package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login2")
public class LoginTest extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);		// 이벤트 핸들러를 생성한 후 세션에 저장합니다.
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);			// 세션에 바인딩 시 LoginImpl의 valueBound()메서드 호출
		}
	
		out.println("<head>");
		out.println("<script  type='text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");		// 5초마다 서블릿에 재요청하여 접속자수를 표시합니다.
		out.println("</script>");
		out.println("</head>");
		out.println("<html><body>");
		out.println("아이디 : " + loginUser.user_id + "<br>");
		out.println("총 접속자수 : " + LoginImpl.total_user + "<br>");
		out.println("</body></html>");
		
	}
	
}
