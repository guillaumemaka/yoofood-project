package com.youfood.backoffice.servlet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youfood.backoffice.utils.AuthenticationError;
import com.youfood.backoffice.utils.Authenticator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(LoginServlet.class.getSimpleName());
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
		log.info("LoginServlet.deGet() call");
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       //auth = new Authenticator();
		log.info("LoginServlet.dePost() call");
		String message = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		log.info("username: "+ username);
		log.info("password: "+ password);
		
		try {
			AuthenticationError status = auth.connect(username,password);
			System.out.println(status);
			switch(status){
			case PasswordMissMatch:
				message = "Password missmatch";
				log.info(message);
				request.setAttribute("error", message);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				break;
			case Success:
				message = "Your are successfully logged in";
				log.info(message);
				request.setAttribute("success", message);
				request.getSession().setAttribute("loggedIn", true);
				request.getSession().setAttribute("full_name", auth.getUserFullName());
				request.getSession().setAttribute("user_id", auth.getUserId());				
				break;
			case UserNotFound:
				message = "Username provided not found in our record";
				log.info(message);
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
		
		request.getRequestDispatcher("/home").forward(request, response);
	}

}
