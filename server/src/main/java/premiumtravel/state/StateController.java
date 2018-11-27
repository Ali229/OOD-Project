package premiumtravel.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.trip.Trip;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 *
 */
public abstract class StateController implements Consumer<HashMap<String, String>> {

	static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	/**
	 *
	 */
	StateController( Trip trip ) {
		super();
	}
}

