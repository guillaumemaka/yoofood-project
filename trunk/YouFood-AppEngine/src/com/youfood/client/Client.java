package com.youfood.client;

import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.restlet.resource.ClientResource;

public class Client {

	/**
	 * @param args
	 * @throws Throwable 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, Throwable {
		
		ClientResource cr = new ClientResource("http://youfood134508.appspot.com/api/users");
		cr.setRequestEntityBuffering(true);
	
		ObjectMapper mapper = new ObjectMapper();				
		List<User> users = mapper.readValue(cr.get().getText(), new TypeReference<List<User>>(){});
		
		if (users != null) {		
			for  (User u : users){				
				System.out.println(u.getLastname());
				System.out.println(u.getFirstname());
			}
		}
	}
}
