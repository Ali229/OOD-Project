package premiumtravel.rest;

import premiumtravel.cache.PremiumTravelCache;
import premiumtravel.people.TravelAgent;
import premiumtravel.state.StateController;
import premiumtravel.trip.Trip;

import javax.ejb.DependsOn;
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
@Path( "trip" )
@DependsOn( { "PackageRegistry", "PersonRegistry", "TravelAgentRegistry", "TravellerRegistry", "TripRegistry",
					"PlaceRegistry", "PremiumTravelCache" } )
public class TripRESTController extends AbstractRESTController {

	@Inject private PremiumTravelCache premiumTravelCache;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTrips() {
		logger.debug( "GET called on /trip" );
		return Response.ok( gson.toJson( this.premiumTravelCache.getTripRegistry().getAll() ) ).build();
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response createTrip( HashMap<String, String> data ) {
		if ( !data.containsKey( "travel-agent-id" ) ) {
			return addHeaders( Response.status( 400, "The request data must include the posting travel-agent-id" ) )
					.build();
		}
		String travelAgentID = data.get( "travel-agent-id" );
		TravelAgent travelAgent = this.premiumTravelCache.getTravelAgentRegistry().get( travelAgentID );
		if ( travelAgent == null ) {
			return addHeaders( Response.status( 400, "The given travel-agent-id is invalid." ) ).build();
		}
		Trip newTrip = new Trip( this.premiumTravelCache, travelAgent );
		this.premiumTravelCache.getTripRegistry().add( newTrip );
		return addHeaders( Response.ok(
				Json.createObjectBuilder().add( "trip-id", newTrip.getID().toString() ).build().toString() ) ).build();
	}

	@GET
	@Path( "{trip-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID ) {
		logger.debug( "GET called on /trip/" + tripID );
		Trip trip = this.premiumTravelCache.getTripRegistry().get( tripID );
		return addHeaders( Response.ok( gson.toJson( trip ) ) ).build();
	}

	@PUT
	@Path( "{trip-id}" )
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response modifyTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID,
			HashMap<String, String> data ) {
		logger.error( "PUT called on /trip/" + tripID );
		logger.error( data );
		for ( Trip trip : this.premiumTravelCache.getTripRegistry().getAll() ) {
			if ( trip.getID().toString().equals( tripID ) ) {
				logger.error( "Found trip" );
				try {
					StateController stateController = trip.getStateController();
					logger.error( stateController.getClass() );
					stateController.accept( this.premiumTravelCache, data );
					return addHeaders( Response.accepted() ).build();
				} catch ( RuntimeException e ) {
					return addHeaders( Response.status( 400, e.getMessage() ) ).build();
				}
			}
		}
		return Response.status( 404, "No trip with the ID of \"" + tripID + "\" exists." ).build();
	}

	@POST
	@Path( "{trip-id}" )
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Response postTrip( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID ) {
		logger.debug( "POST called on /trip/" + tripID );
		for ( Trip trip : this.premiumTravelCache.getTripRegistry().getAll() ) {
			if ( trip.getID().toString().equals( tripID ) ) {
				try {
					trip.getStateController().nextState();
					return addHeaders( Response.accepted() ).build();
				} catch ( RuntimeException e ) {
					return addHeaders( Response.status( 400, e.getMessage() ) ).build();
				}
			}
		}
		return addHeaders( Response.status( 404, "No trip with the ID of \"" + tripID + "\" exists." ) ).build();
	}

	@GET
	@Path( "{trip-id}/bill" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTripBill( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID ) {
		logger.debug( "GET called on /trip/" + tripID + "/bill" );
		Trip trip = this.premiumTravelCache.getTripRegistry().get( tripID );
		try {
			return addHeaders( Response.ok( gson.toJson( trip.getBill().getBillText() ) ) ).build();
		} catch ( RuntimeException e ) {
			return addHeaders( Response.status( 400, e.getMessage() ) ).build();
		}
	}

	@GET
	@Path( "{trip-id}/bill/amount" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTripBillAmount( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID ) {
		logger.debug( "GET called on /trip/" + tripID + "/bill" );
		Trip trip = this.premiumTravelCache.getTripRegistry().get( tripID );
		try {
			return addHeaders( Response.ok( gson.toJson( trip.getBill().getTotalPrice() ) ) ).build();
		} catch ( RuntimeException e ) {
			return addHeaders( Response.status( 400, e.getMessage() ) ).build();
		}
	}

	@GET
	@Path( "{trip-id}/itinerary" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTripItinerary( @DefaultValue( "-1" ) @PathParam( "trip-id" ) String tripID ) {
		logger.debug( "GET called on /trip/" + tripID + "/itinerary" );
		Trip trip = this.premiumTravelCache.getTripRegistry().get( tripID );
		try {
			return addHeaders( Response.ok( gson.toJson( trip.getBill() ) ) ).build(); // TODO Change bill to itinerary
		} catch ( RuntimeException e ) {
			return addHeaders( Response.status( 400, e.getMessage() ) ).build();
		}
	}
}
