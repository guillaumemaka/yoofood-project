package com.youfood.server.restlet.resources;

import java.util.List;

import org.restlet.resource.Get;

import com.youfood.client.User;

public interface RootControllerResource {
	@Get
	List<User> getUsers();
}
