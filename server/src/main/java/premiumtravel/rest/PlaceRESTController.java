package premiumtravel.rest;

import premiumtravel.cache.PackageRegistry;
import premiumtravel.cache.PlaceRegistry;
import premiumtravel.trip.Place;
import premiumtravel.trip.TravelPackage;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
@Path( "/place" )
public class PlaceRESTController extends AbstractRESTController {

	/**
	 * Singleton bean instantiated by Java EE
	 */
	@EJB private PlaceRegistry placeRegistry;

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTravelAgents() {
		return addHeaders( Response.ok( gson.toJson( placeRegistry.getAll() ) ) ).build();
	}

	@GET
	@Path( "{place-id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response getTravelAgent( @DefaultValue( "-1" ) @PathParam( "place-id" ) String packageID ) {
		logger.trace( "GET called on /place/" + packageID );
		for ( Place place : placeRegistry.getAll() ) {
			if ( place.getID().toString().equals( packageID ) ) {
				return addHeaders( Response.ok( gson.toJson( place ) ) ).build();
			}
		}
		return addHeaders( Response.status( 400, "No Place with that ID exists." ) ).build();
	}
}
