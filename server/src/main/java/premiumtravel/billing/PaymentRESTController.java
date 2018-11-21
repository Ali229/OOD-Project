package premiumtravel.billing;

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
@Path( "/trip/{trip-id}/payment" )
public class PaymentRESTController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	//	@POST
	//	public JsonObject postPayment( @PathParam( "trip-id" ) Integer tripID ) {
	//
	//	}

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public JsonObject getPayment( @DefaultValue( "-1" ) @PathParam( "trip-id" ) Integer tripID ) {
		logger.debug( "GET called on /trip/" + tripID + "/payment" );
		return Json.createObjectBuilder().add( "payment", "none" ).build();
	}
}
