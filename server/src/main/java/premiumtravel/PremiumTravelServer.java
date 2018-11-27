package premiumtravel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.rest.*;

import javax.annotation.Priority;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MultivaluedMap;
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
		h.add( BillRESTController.class );
		h.add( PaymentRESTController.class );
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
	@Priority( Priorities.HEADER_DECORATOR )
	public class AccessControlResponseFilter implements ContainerResponseFilter {

		@Override
		public void filter( ContainerRequestContext requestContext, ContainerResponseContext responseContext )
				throws IOException {
			final MultivaluedMap<String, Object> headers = responseContext.getHeaders();

			headers.add( "Access-Control-Allow-Origin", "*" );
			headers.add( "Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type" );
			headers.add( "Access-Control-Expose-Headers", "Location, Content-Disposition" );
			headers.add( "Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS" );
		}
	}
}
