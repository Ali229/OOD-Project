package premiumtravel.rest;

import premiumtravel.cache.TravelAgentRegistry;
import premiumtravel.people.Person;
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
public class TravelAgentRESTController extends AbstractRESTController {

	/**
	 * Singleton bean instantiated by Java EE
	 */
	@EJB private TravelAgentRegistry travelAgentRegistry;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@EJB private PersonFactory personFactory;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTravelAgents() {
		logger.error( "GET called on /travel-agent" );
		return addHeaders( Response.ok( gson.toJson( travelAgentRegistry.getAll() ) ) ).build();
	}

	@GET
	@Path( "{travel-agent-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTravelAgent( @DefaultValue( "-1" ) @PathParam( "travel-agent-id" ) String travelAgentID ) {
		logger.error( "GET called on /travel-agent/" + travelAgentID );
		for ( TravelAgent agent : travelAgentRegistry.getAll() ) {
			if ( agent.getPersonID().equals( travelAgentID ) ) {
				return addHeaders( Response.ok( gson.toJson( agent ) ) ).build();
			}
		}
		return addHeaders( Response.status( 400, "No Travel Agent with that ID exists." ) ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response postTravelAgent( HashMap<String, String> data ) {
		logger.trace( "POST called on /travel-agent with data: " + data.toString() );
		Person travelAgent = this.personFactory
				.getPerson( PersonFactory.PersonType.TravelAgent, data.get( "firstName" ), data.get( "lastName" ),
						data.get( "phoneNumber" ) );//data.firstName, data.lastName, data.phoneNumber );
		return addHeaders(
				Response.accepted( Json.createObjectBuilder().add( "person_id", travelAgent.getPersonID() ).build() ) )
				.build();
	}
}
