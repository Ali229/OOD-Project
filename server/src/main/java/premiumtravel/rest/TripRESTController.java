package premiumtravel.rest;

import premiumtravel.cache.TravelAgentRegistry;
import premiumtravel.cache.TripRegistry;
import premiumtravel.people.TravelAgent;
import premiumtravel.trip.Trip;

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
@Path( "trip" )
public class TripRESTController extends AbstractRESTController {

	@EJB private TripRegistry tripRegistry;
	@EJB private TravelAgentRegistry travelAgentRegistry;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTrips() {
		logger.debug( "GET called on /trip" );
		return Response.ok( gson.toJson( this.tripRegistry.getAll() ) ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createTrip( HashMap<String, String> data ) {
		if ( !data.containsKey( "travel-agent-id" ) ) {
			return Response.status( 400, "The request data must include the posting travel-agent-id" ).build();
		}
		String travelAgentID = data.get( "travel-agent-id" );
		TravelAgent travelAgent = this.travelAgentRegistry.get( travelAgentID );
		if ( travelAgent == null ) {
			return Response.status( 400, "The given travel-agent-id is invalid." ).build();
		}
		Trip newTrip = new Trip( travelAgent );
		this.tripRegistry.add( newTrip );
		return Response.status( 201,
				Json.createObjectBuilder().add( "trip-id", newTrip.getID().toString() ).build().toString() ).build();
	}

	@GET
	@Path( "{trip-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID ) {
		logger.debug( "GET called on /trip/" + tripID );
		Trip trip = this.tripRegistry.get( tripID );
		return Response.ok( gson.toJson( trip ) ).build();
	}

	@PUT
	@Path( "{trip-id}" )
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response modifyTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID,
			HashMap<String, String> data ) {
		logger.debug( "PUT called on /trip/" + tripID );
		for ( Trip trip : this.tripRegistry.getAll() ) {
			if ( trip.getID().toString().equals( tripID ) ) {
				try {
					trip.getStateController().accept( data );
					return Response.accepted().build();
				} catch ( RuntimeException e ) {
					return Response.status( 400, e.getMessage() ).build();
				}
			}
		}
		return Response.status( 404, "No trip with the ID of \"" + tripID + "\" exists." ).build();
	}

	@POST
	@Path( "{trip-id}" )
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response postTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID,
			HashMap<String, String> data ) {
		logger.debug( "POST called on /trip/" + tripID );
		for ( Trip trip : this.tripRegistry.getAll() ) {
			if ( trip.getID().toString().equals( tripID ) ) {
				try {
					trip.getStateController().nextState();
					return Response.accepted().build();
				} catch ( RuntimeException e ) {
					return Response.status( 400, e.getMessage() ).build();
				}
			}
		}
		return Response.status( 404, "No trip with the ID of \"" + tripID + "\" exists." ).build();
	}
}
