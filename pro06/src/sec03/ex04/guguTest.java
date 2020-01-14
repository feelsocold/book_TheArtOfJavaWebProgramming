package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guguTest")
public class guguTest extends HttpServlet {
	public void init() {
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		int dan = Integer.parseInt(req.getParameter("dan"));
		System.out.println(dan);
		
		PrintWriter out = resp.getWriter();
		String str = "";
		str += "<table border=1 width=800 align=center>";
		str += "<tr align=center bgcolor=#FFFF66>";
		str += "<td colspan=2>" + dan + "단 출력 </td>";
		str += "</tr>";
		
		for (int i = 1; i < 10; i++) {
			str += "<tr align=center>";
			str += "<td width=400>";
			str += dan + " * " + i + " = ";
			str += (i* dan) + "";
			str += "</td>";
			str += "</tr>";
		}
		str += "</table>";
		out.print(str);
	}
	
}
