package com.supinfo.notetonsta.resources;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/interventions")
public class RestApiServlet{

	@GET 
	@Path("/hello")
	@Produces("text/plain")
	public String hello(){
		return "Hello World";
	}
	
	@GET 
	@Path("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String,String> helloJSON(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("hello", "world");
		return map;
	}
}
