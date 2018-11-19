package premiumtravel.billing;

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
@Path( "/trip/{trip-id}/bill" )
public class BillController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	@GET
	public JsonObject getBill( @PathParam( "trip-id" ) Integer tripID ) {
		logger.error( "GET called on /trip/" + tripID + "/bill" );
		return Json.createObjectBuilder().add( "bill", "stuff" ).build();
	}
}
