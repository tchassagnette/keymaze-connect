package fr.keymaze.connect.back.resource;

import fr.keymaze.connect.back.model.Activity;
import fr.keymaze.connect.back.service.ActivityService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/activity")
public class ActivityResource {

    @Inject
    private ActivityService activityService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Activity getActivity(@PathParam("id") String id) {
        return activityService.getActivity(id);
    }
}
