package com.youfood.backoffice.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, 
		urlPatterns = {
				"/home",
				"/user/*",
				"/menu/*",
				"/stats/*"
		})
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {			
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		Boolean loggedIn = false;			
		String contextPath = httpRequest.getContextPath();
		
		try{
			loggedIn = (Boolean) session.getAttribute("loggedIn");
						
			if ( loggedIn ){
				chain.doFilter(request, response);
			}else{				
				//httpResponse.sendRedirect(httpResponse.encodeRedirectURL(contextPath + "/login"));
				httpRequest.getRequestDispatcher("/jsp/login.jsp").forward(httpRequest, httpResponse);
			}
			
		}catch(NullPointerException e){
			//httpResponse.sendRedirect(httpResponse.encodeRedirectURL(contextPath + "/login"));
			httpRequest.getRequestDispatcher("/jsp/login.jsp").forward(httpRequest, httpResponse);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
