package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Path( "trip/{trip-id}" )
public class TripRESTController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public JsonObject getTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) Integer tripID ) {
		logger.debug( "GET called on /trip/" + tripID );
		return Json.createObjectBuilder().add( "trip", "none" ).build();
	}
}
