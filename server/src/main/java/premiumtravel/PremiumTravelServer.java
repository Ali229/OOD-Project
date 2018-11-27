package premiumtravel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.rest.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@ApplicationPath( "/" )
public class PremiumTravelServer extends Application {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> h = new HashSet<>();
		h.add( RootPath.class );
		h.add( TripRESTController.class );
		h.add( TravelAgentRESTController.class );
		h.add( PersonRESTController.class );
		return h;
	}

	@Path( "/" )
	public static class RootPath {
		@GET
		public JsonObject getWelcome() {
			return Json.createObjectBuilder().add( "message", "Welcome to the Premium-Travel backend!" ).build();
		}
	}

	@Provider
	public class CORSFilter implements ContainerResponseFilter {

		@Override
		public void filter( ContainerRequestContext request, ContainerResponseContext response ) throws IOException {
			System.err.println("We're in!");
			response.getHeaders().add( "Access-Control-Allow-Origin", "*" );
			response.getHeaders().add( "Access-Control-Allow-Headers", "origin, content-type, accept, authorization" );
			response.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
			response.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD" );
		}
	}

}
