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
@Path( "/person" )
public class PersonRESTController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

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
	public JsonObject postTravelAgent( PersonRESTController.NewPersonParameters data ) {
		logger.debug( "POST called on /person with data: " + data.toString() );
		Person person = new Person( data.firstName, data.lastName, data.phoneNumber );
		return Json.createObjectBuilder().add( "person_id", person.getPersonID() ).build();
	}

	public static class NewPersonParameters {
		String firstName;
		String lastName;
		String phoneNumber;

		@Override
		public String toString() {
			return "firstName: " + firstName + ", lastName" + lastName + ", phoneNumber: " + phoneNumber;
		}
	}
}
