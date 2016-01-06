package cn.zj.sunda.water.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WarnSerch extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====");
		request.setAttribute("obj", "nihaoa");
		request.getRequestDispatcher("/pages/work/search.faces").forward(request,response);
		
		
	}

}
