package premiumtravel.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.people.Person;
import premiumtravel.people.PersonFactory;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Path( "/person" )
public class PersonRESTController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	/**
	 * Singleton bean instantiated by Java EE
	 */
	@EJB private PersonFactory personFactory;

	@GET
	@Path( "{person-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public JsonObject getTravelAgent( @DefaultValue( "-1" ) @PathParam( "person-id" ) String personID ) {
		logger.debug( "GET called on /person/" + personID );
		return Json.createObjectBuilder().add( "bill", "stuff" ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public JsonObject postTravelAgent( HashMap<String, String> data ) {
		logger.debug( "POST called on /person with data: " + data.toString() );
		Person person = this.personFactory
				.getGuest( data.get( "firstName" ), data.get( "lastName" ), data.get( "phoneNumber" ) );
		return Json.createObjectBuilder().add( "person_id", person.getPersonID() ).build();
	}
}