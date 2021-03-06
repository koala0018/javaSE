package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("过滤器启动");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		
	    String userid = (String)session.getAttribute("userid");
	    System.out.println("过滤器中的session地址"+session);
	  //ServletContext application = session.getServletContext();
//		if(application.getAttribute("onlineMember")==null){
//			System.out.println("onlineMember为空"); 	
//			request.setAttribute("errorinfo", "请登录");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			return;
//			 }
		if(userid==null||userid.trim()==""){			 	
			request.setAttribute("errorinfo", "请登录");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
	    	
	   arg2.doFilter(request, response); 	
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
