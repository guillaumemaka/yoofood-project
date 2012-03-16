package com.youfood.backoffice.servlet.user;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youfood.backoffice.utils.Authenticator;
import com.youfood.dao.jpa.JpaUserDao;
import com.youfood.entity.User;
import com.youfood.exception.UserException;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet({ "/user/create", "/user" })
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private JpaUserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/user/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String contextPath = request.getContextPath();
		String username = request.getParameter("username");
		String fullname = request.getParameter("firstname") + " " + request.getParameter("lastname");
		String password;
		User user = new User();
		
		try {
			password = Authenticator.hash(request.getParameter("password"), "UTF-8");
						
			
			user.setFullname(fullname);
			user.setUsername(username);
			user.setPassword(password);	
			
			userDao.create(user);
		} catch (UserException e) {
			request.setAttribute("error", e.getMessage());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		} 
		
		request.setAttribute("success", "User " + user.getFullname() + " created successfully");
		request.getRequestDispatcher("/user").forward(request, response);
		//response.sendRedirect(response.encodeRedirectURL(contextPath + "/user"));		
	}

}
