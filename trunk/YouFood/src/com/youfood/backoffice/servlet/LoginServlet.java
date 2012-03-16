package com.youfood.backoffice.servlet;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youfood.backoffice.utils.Authenticator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private Authenticator auth;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String message = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			switch(auth.connect(username,password)){
			case PasswordMissMatch:
				message = "Password missmatch";
				request.setAttribute("error", message);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				break;
			case Success:
				message = "Your are successfully logged in";
				request.setAttribute("success", message);
				request.getSession().setAttribute("loggedIn", true);
				request.getSession().setAttribute("full_name", auth.getUserFullName());
				request.getSession().setAttribute("user_id", auth.getUserId());				
				break;
			case UserNotFound:
				message = "Username provided not found in our record";
				request.setAttribute("error", message);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				break;		
			}
		} catch (GeneralSecurityException e) {
			
			message = e.getMessage();
			request.setAttribute("error", message);
			
		} catch (Exception e) {
			message = e.getMessage();
			request.setAttribute("error", message);
		}
		
		request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
	}

}
