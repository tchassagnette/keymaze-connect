package fr.keymaze.connect.back.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import fr.keymaze.connect.back.dao.ActivityDao;
import fr.keymaze.connect.back.dao.impl.ActivityDaoImpl;
import fr.keymaze.connect.back.resource.ActivityResource;
import fr.keymaze.connect.back.service.ActivityService;
import fr.keymaze.connect.back.service.ActivityServiceImpl;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import java.util.HashMap;
import java.util.Map;

public class KeymazeConnectGuiceServletConfig extends
        GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {
            @Override
            protected void configureServlets() {
                final Map<String, String> initParams = new HashMap<String, String>();
                initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
                bind(ActivityResource.class);
                bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);
                bind(ActivityDao.class).to(ActivityDaoImpl.class);
                bind(ActivityService.class).to(ActivityServiceImpl.class);
                // Route all requests through GuiceContainer
                serve("/*").with(GuiceContainer.class, initParams);

            }
        });
    }
}
