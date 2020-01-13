package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html); charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		String command = req.getParameter("command");
		String won = req.getParameter("won");
		String operator = req.getParameter("operator");
		
//		if(command != null && command.equals("calculate")) {
//			String result = calculate(Float.parseFloat(won), operator);
//		}
//		
//		
//		private static String calculate(float won, String operator) {
//			String result = null;
//			
//			if(operator.equals("dollar")) {
//				result = String.format("%.6f", won / USD_RATE);
//			}
//			
//			
//			return result;
//		}
		
	}
}
