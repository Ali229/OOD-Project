package premiumtravel.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.PremiumTravelCache;
import premiumtravel.trip.Trip;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 *
 */
public abstract class StateController implements BiConsumer<PremiumTravelCache, HashMap<String, String>> {

	static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	final Trip trip;

	/**
	 *
	 */
	StateController( Trip trip ) {
		this.trip = trip;
	}

	/**
	 * Attempts to progress to the next state, or throws a {@link RuntimeException} if unable to.
	 */
	public abstract void nextState();
}

