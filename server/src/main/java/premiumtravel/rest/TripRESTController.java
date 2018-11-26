package premiumtravel.rest;

import premiumtravel.cache.TripRegistry;
import premiumtravel.trip.Trip;

import javax.ejb.EJB;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Path( "trip" )
public class TripRESTController extends AbstractRESTController {

	@EJB private TripRegistry tripRegistry;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTrips() {
		logger.debug( "GET called on /trip" );
		return Response.ok( gson.toJson( this.tripRegistry.getAll() ) ).build();
	}

	@GET
	@Path( "{trip-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID ) {
		logger.debug( "GET called on /trip/" + tripID );
		for ( Trip trip : this.tripRegistry.getAll() ) {
			if ( trip.getID().toString().equals( tripID ) ) {
				return Response.ok( gson.toJson( trip ) ).build();
			}
		}
		return Response.noContent().build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	public Response createTrip() {
		Trip newTrip = new Trip();
		this.tripRegistry.add( newTrip );
		return Response.status( 201,
				Json.createObjectBuilder().add( "trip-id", newTrip.getID().toString() ).build().toString() ).build();
	}
}
