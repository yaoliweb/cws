package cn.zj.sunda.water.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginFilter implements Filter {

	private String redirectURL="/";
	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)servletRequest; 
		HttpServletResponse response = (HttpServletResponse)servletResponse; 
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null)
		{
			System.out.println(request.getContextPath()+"++++++++++");
			response.sendRedirect(request.getContextPath() + redirectURL); 
			
		}
		else
		{
			filterChain.doFilter(request, response); 
		}
	}


	public void init(FilterConfig filterConfig) throws ServletException {
		redirectURL=filterConfig.getInitParameter("redirectURL");
	}
}