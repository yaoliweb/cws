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

public class TimeOutFilter implements Filter {
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    
    HttpSession session = req.getSession(false);

    //get Session
    String username = (String) session.getAttribute("user");
    
    //Session Timeout
    if (username == null || "".equals(username)) {
      //to login
    	System.out.println(req.getContextPath()+"================");
      String newUrl = req.getContextPath() + "/login.faces";
   	  res.sendRedirect(newUrl);
    }
    else {
      chain.doFilter(request,response);
    }
  }

  public void destroy() {
  }
} 