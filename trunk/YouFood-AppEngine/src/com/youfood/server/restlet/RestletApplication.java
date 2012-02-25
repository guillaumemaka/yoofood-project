package com.youfood.server.restlet;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.engine.Engine;
import org.restlet.ext.gwt.GwtConverter;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.ext.json.JsonConverter;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

import com.youfood.server.restlet.resources.RootController;

public class RestletApplication extends Application {

	@Override
	public Restlet createInboundRoot() {
		super.createInboundRoot();
		
		Engine.getInstance().getRegisteredConverters().clear();
		Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
		Engine.getInstance().getRegisteredConverters().add(new GwtConverter());
		//Engine.getInstance().getRegisteredConverters().add(new JsonConverter());
		
		Router router = new Router(this.getContext());
		
		router.attachDefault(new Directory(this.getContext(), "war:///"));
		router.attach("/users",RootController.class);
		
		return router;
	}

}
