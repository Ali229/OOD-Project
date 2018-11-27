package premiumtravel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.rest.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
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
		h.add( TravellerRESTController.class );
		h.add( PackageRESTController.class );
		return h;
	}

	@Path( "/" )
	public static class RootPath {
		@GET
		public JsonObject getWelcome() {
			return Json.createObjectBuilder().add( "message", "Welcome to the Premium-Travel backend!" ).build();
		}
	}
}
