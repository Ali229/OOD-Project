package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Path( "trip/{trip-id}" )
public class TripController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	@GET
	public JsonObject getTrip( @PathParam( "trip-id" ) Integer tripID ) {
		logger.debug( "GET called on /trip/" + tripID );
		return Json.createObjectBuilder().add( "trip", "none" ).build();
	}
}
