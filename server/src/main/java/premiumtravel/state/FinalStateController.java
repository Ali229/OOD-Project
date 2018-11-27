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
	public void accept( HashMap<String, String> stringStringHashMap ) {

	}
}

