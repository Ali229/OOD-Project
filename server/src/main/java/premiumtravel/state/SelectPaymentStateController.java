package premiumtravel.state;

import premiumtravel.trip.Trip;

import java.util.HashMap;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
public class SelectPaymentStateController extends StateController {
	/**
	 * @param trip
	 */
	SelectPaymentStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {

	}

	@Override
	public void accept( HashMap<String, String> stringStringHashMap ) {

	}
}
