package com.youfood.backoffice.servlet.user;

import java.io.IOException;

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
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/user/delete/*")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
    private JpaUserDao userDao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = new User();
		user.setId(id);
		try {
			userDao.delete(user);
		} catch (UserException e) {
			request.setAttribute("error", e.getMessage());
		}
		
		request.setAttribute("success", "User " + user + " deleted successfully");
		request.getRequestDispatcher("/user").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
