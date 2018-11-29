package premiumtravel.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.PremiumTravelCache;
import premiumtravel.people.Traveller;
import premiumtravel.trip.Trip;

import java.util.HashMap;

/**
 *
 */
public class AddTravelersStateController extends StateController {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	/**
	 *
	 */
	AddTravelersStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {
		if ( this.trip.getTravellers().size() > 0 ) {
			this.trip.setState( States.ADD_PACKAGES );
		} else {
			throw new RuntimeException(
					"The trip must have at least 1 traveller in order to progress to the next state" );
		}
	}

	@Override
	public void accept( PremiumTravelCache premiumTravelCache, HashMap<String, String> data ) {
		if ( !data.containsKey( "traveller-id" ) ) {
			throw new RuntimeException( "The data must contain the key \"traveller-id\" and its associated value" );
		}
		logger.error( "Data contains traveller-id" );
		String travellerID = data.get( "traveller-id" );
		Traveller traveller = premiumTravelCache.getTravellerRegistry().get( travellerID );
		this.trip.addTraveller( traveller );
	}
}

