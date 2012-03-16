package com.youfood.backoffice.servlet.user;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youfood.dao.jpa.JpaUserDao;
import com.youfood.entity.User;

/**
 * Servlet implementation class IndexUserServlet
 */
@WebServlet("/user")
public class IndexUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(IndexUserServlet.class.getSimpleName()); 
    
	@EJB
    private JpaUserDao userDao; 
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public IndexUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * TODO
		 * 
		 * Paginating users
		 * 
		 */
		
		List<User> users = userDao.findAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
