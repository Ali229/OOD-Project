package premiumtravel.rest;

import premiumtravel.cache.TravellerRegistry;
import premiumtravel.people.Person;
import premiumtravel.people.PersonFactory;
import premiumtravel.people.Traveller;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Path( "/traveller" )
public class TravellerRESTController extends AbstractRESTController {

	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private TravellerRegistry travellerRegistry;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private PersonFactory personFactory;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTravelAgents() {
		return addHeaders( Response.ok( gson.toJson( travellerRegistry.getAll() ) ) ).build();
	}

	@GET
	@Path( "{traveller-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTravelAgent( @DefaultValue( "-1" ) @PathParam( "traveller-id" ) String travellerID ) {
		logger.trace( "GET called on /traveller/" + travellerID );
		for ( Traveller traveller : travellerRegistry.getAll() ) {
			if ( traveller.getPersonID().equals( travellerID ) ) {
				return addHeaders( Response.ok( gson.toJson( traveller ) ) ).build();
			}
		}
		return addHeaders( Response.status( 400, "No Traveller with that ID exists." ) ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response postTravelAgent( HashMap<String, String> data ) {
		logger.trace( "POST called on /traveller with data: " + data.toString() );
		Person traveller = this.personFactory
				.getPerson( PersonFactory.PersonType.Traveller, data.get( "firstName" ), data.get( "lastName" ),
						data.get( "phoneNumber" ) );//data.firstName, data.lastName, data.phoneNumber );
		return addHeaders(
				Response.accepted( Json.createObjectBuilder().add( "person_id", traveller.getPersonID() ).build() ) )
				.build();
	}
}
