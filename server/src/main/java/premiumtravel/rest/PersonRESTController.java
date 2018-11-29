package premiumtravel.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.PersonRegistry;
import premiumtravel.people.Person;
import premiumtravel.people.PersonFactory;

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
@Path( "/person" )
public class PersonRESTController extends AbstractRESTController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private PersonFactory personFactory;
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@Inject private PersonRegistry personRegistry;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getPeople() {
		return addHeaders( Response.ok( gson.toJson( personRegistry.getAll() ) ) ).build();
	}

	@GET
	@Path( "{person-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getPerson( @DefaultValue( "-1" ) @PathParam( "person-id" ) String personID ) {
		logger.trace( "GET called on /person/" + personID );
		for ( Person person : personRegistry.getAll() ) {
			if ( person.getPersonID().equals( personID ) ) {
				return addHeaders( Response.ok( gson.toJson( person ) ) ).build();
			}
		}
		return addHeaders( Response.status( 400, "No Person with that ID exists." ) ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response postTravelAgent( HashMap<String, String> data ) {
		logger.trace( "POST called on /person with data: " + data.toString() );
		Person guest = this.personFactory
				.getPerson( PersonFactory.PersonType.SystemGuest, data.get( "firstName" ), data.get( "lastName" ),
						data.get( "phoneNumber" ) );//data.firstName, data.lastName, data.phoneNumber );
		return addHeaders(
				Response.accepted( Json.createObjectBuilder().add( "person_id", guest.getPersonID() ).build() ) )
				.build();
	}
}
