package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncoderFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter 호출");
		
		request.setCharacterEncoding("utf-8");
		
		String context = ((HttpServletRequest) request).getContextPath();	// 웹 애플리케이션의 컨텍스트 이름을 가져온다.
		String pathInfo = ((HttpServletRequest) request).getRequestURI();	// 웹 브라우저에서 요청한 요청URI를 가져온다.
		String realPath = request.getRealPath(pathInfo);					// 요청 URI의 실제경로를 가져온다.
		
		String mesg = "Context 정보 : " + context + "\n URI 정보 : " + pathInfo + "\n 물리적 정보 : "  + realPath;
		
		System.out.println(mesg);
		
		long begin = System.currentTimeMillis();	// 요청 필터에서 요청 처리 전의 시각을 구한다.

		///////
		chain.doFilter(request, response);			// 이 라인을 기준으로 위 쪽은 request 필터기능을 설정하고, 밑 쪽은 response 필터기능 설정
		///////
		
		long end = System.currentTimeMillis();					// 응답 필터에서 요청 처리 후의 시각을 구한다.
		System.out.println("작업 시간 : " + (end-begin)+"ms");		//	작업 요청 전과 후의 시각 차를 구해 작업 수행 시간을 구한다.
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
