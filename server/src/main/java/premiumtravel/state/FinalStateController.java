package premiumtravel.state;

import premiumtravel.trip.Trip;

import java.util.HashMap;

/**
 *
 */
public class FinalStateController extends StateController {

	/**
	 *
	 */
	FinalStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {
		throw new RuntimeException( "Already at the last state. Unable to advance any further." );
	}

	@Override
	public void accept( HashMap<String, String> stringStringHashMap ) {
		throw new RuntimeException( "PUT requests are not accepted now that the trip has been finalized." );
	}
}

