package fr.keymaze.connect.back.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.keymaze.connect.back.model.Activity;

@Path("/activity")
public class ActivityResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Activity getActivity(String id){
		final Activity activity = new Activity();
		activity.setId(id);
		return activity;
	}
}
