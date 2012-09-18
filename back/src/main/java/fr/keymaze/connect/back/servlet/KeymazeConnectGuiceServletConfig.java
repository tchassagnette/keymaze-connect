package fr.keymaze.connect.back.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import fr.keymaze.connect.back.resource.ActivityResource;

public class KeymazeConnectGuiceServletConfig extends
		GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {
	         @Override
	         protected void configureServlets() {
	            bind(ActivityResource.class);
	            // Route all requests through GuiceContainer
	            serve("/*").with(GuiceContainer.class);
	         }
	      });
	}

}
