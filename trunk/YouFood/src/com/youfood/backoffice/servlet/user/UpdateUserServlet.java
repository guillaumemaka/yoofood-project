package com.youfood.backoffice.servlet.user;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youfood.dao.jpa.JpaUserDao;
import com.youfood.entity.User;
import com.youfood.exception.UserException;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/user/update")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Logger log = Logger.getLogger(UpdateUserServlet.class.getSimpleName());
	@EJB
	private JpaUserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/user"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		User user = userDao.find(id);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		
		try {										
			userDao.update(user);
		} catch (UserException e) {
			request.setAttribute("error", e.getMessage());
			log.severe(e.getMessage());
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			log.severe(e.getMessage());
		} 
		
		request.setAttribute("success", "User " + user + " updated successfully");
		request.getRequestDispatcher("/user").forward(request, response);
	}

}
