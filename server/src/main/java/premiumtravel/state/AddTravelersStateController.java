package premiumtravel.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public AddTravelersStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void accept( HashMap<String, String> stringStringHashMap ) {

	}
}

