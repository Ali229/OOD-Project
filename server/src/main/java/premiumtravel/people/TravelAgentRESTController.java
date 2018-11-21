package premiumtravel.people;

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
@Path( "/travel-agent" )
public class TravelAgentRESTController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	@GET
	@Path( "{travel-agent-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public JsonObject getTravelAgent( @DefaultValue( "-1" ) @PathParam( "travel-agent-id" ) String travelAgentID ) {
		logger.trace( "GET called on /travel-agent/" + travelAgentID );
		return Json.createObjectBuilder().add( "bill", "stuff" ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public JsonObject postTravelAgent( PersonRESTController.NewPersonParameters data ) {
		logger.trace( "POST called on /travel-agent with data: " + data.toString() );
		TravelAgent travelAgent = new TravelAgent( data.firstName, data.lastName, data.phoneNumber );
		return Json.createObjectBuilder().add( "person_id", travelAgent.getPersonID() ).build();
	}

}
