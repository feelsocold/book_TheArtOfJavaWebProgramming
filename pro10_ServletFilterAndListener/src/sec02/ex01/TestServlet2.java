package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		String context = req.getContextPath();			// 컨텍스트 이름만 가져온다.
		String url = req.getRequestURL().toString();	// 전체 URL만 가져온다.
		String mapping = req.getServletPath();			// 서블릿 매핑 이름만 가져온다.
		String uri = req.getRequestURI();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet1</title>");
		out.println("</head>");
		out.println("<body bgcolor='orange'>");
		out.println("<b>TestServlet2입니다.</b><br>");
		out.println("<b>컨텍스트명 : "+ context + "</b><br>");
		out.println("<b>전체경로 : "+ url +"<b><br>");
		out.println("<b>매핑명 : "+mapping+"<b><br>");
		out.println("<b>URI : " + uri + "<b>");	
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}
	
}
