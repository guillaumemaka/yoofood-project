package com.youfood.server.restlet.resources;

import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.ServerResource;

import com.youfood.client.User;

public class RootController extends ServerResource implements
		RootControllerResource {

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		users.add(new User("Maka", "Guillaume"));
    	users.add(new User("Beunon", "Mathias"));
		
		return users;
	}
}
