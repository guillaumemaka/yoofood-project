package com.supinfo.notetonsta.jaxrs;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("interventions")
public class RestApiServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7526870702617166669L;
	
	@GET 
	@Path("hello")
	@Produces("plain/text")
	public String hello(){
		return "Hello World";
	}
}
