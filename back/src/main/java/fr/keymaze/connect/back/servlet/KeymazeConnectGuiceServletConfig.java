package fr.keymaze.connect.back.servlet;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

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
	            bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);
	            // Route all requests through GuiceContainer
	            serve("/*").with(GuiceContainer.class);
	         }
	      });
	}

}
