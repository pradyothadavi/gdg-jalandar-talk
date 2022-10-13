package in.adavi.pradyot.resources;

import com.github.pradyothadavi.annotation.RateLimit;
import com.google.inject.Inject;
import in.adavi.pradyot.api.Event;
import in.adavi.pradyot.app.auth.AppUser;
import in.adavi.pradyot.core.EventManager;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/event")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {
  
  private EventManager eventManager;
  
  @Inject
  public EventResource(EventManager eventManager) {
    this.eventManager = eventManager;
  }
  
  @POST
  public Response createEvent(Event event) {
    String eventId = eventManager.add(event);
    event.setId(eventId);
    return Response.ok(event).build();
  }
  
  @GET
  @Path("/name/{eventName}")
  @RateLimit(ratePerSecond = 2)
  @RolesAllowed("ADMIN")
  public Response getByName(@PathParam("eventName") String eventName, @Auth AppUser appUser) {
    if(null != appUser) {
      Event event = eventManager.getByName(eventName);
      return Response.ok(event).build();
    }
    return Response.status(Response.Status.UNAUTHORIZED).build();
  }
}
