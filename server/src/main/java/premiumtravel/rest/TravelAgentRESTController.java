package premiumtravel.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.TravelAgentRegistry;
import premiumtravel.people.PersonFactory;
import premiumtravel.people.TravelAgent;

import javax.ejb.EJB;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Path( "/travel-agent" )
public class TravelAgentRESTController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final Gson gson;

	static {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.enableComplexMapKeySerialization();
		gsonBuilder.generateNonExecutableJson();
		gsonBuilder.serializeNulls();
		gson = gsonBuilder.create();
	}

	/**
	 * Singleton bean instantiated by Java EE
	 */
	@EJB private TravelAgentRegistry travelAgentRegistry;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@EJB private PersonFactory personFactory;

	@GET
	@Path( "{travel-agent-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTravelAgent( @DefaultValue( "-1" ) @PathParam( "travel-agent-id" ) String travelAgentID ) {
		logger.trace( "GET called on /travel-agent/" + travelAgentID );
		for ( TravelAgent agent : travelAgentRegistry.getAll() ) {
			if ( agent.getPersonID().equals( travelAgentID ) ) {
				logger.error( gson.toJson( agent ) );
				return Response.ok( Json.createObjectBuilder().add( "travel-agents", gson.toJson( agent ) ).build() )
						.build();
			}
		}
		return Response.status( 400, "No Travel Agent with that ID exists." ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response postTravelAgent( HashMap<String, String> data ) {
		logger.trace( "POST called on /travel-agent with data: " + data.toString() );
		TravelAgent travelAgent = this.personFactory.getTravelAgent( data.get( "firstName" ), data.get( "lastName" ),
				data.get( "phoneNumber" ) );//data.firstName, data.lastName, data.phoneNumber );
		return Response.accepted( Json.createObjectBuilder().add( "person_id", travelAgent.getPersonID() ).build() )
				.build();
	}
}
