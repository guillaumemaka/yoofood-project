package com.supinfo.servlet.custom;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ActionServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ActionServlet(){
		super();
	}
		
	protected abstract void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	protected abstract void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	protected abstract void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
