package premiumtravel.state;

import premiumtravel.trip.Trip;

import java.util.HashMap;

/**
 *
 */
public class AddPackagesStateController extends StateController {

	/**
	 *
	 */
	public AddPackagesStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {
		if ( this.trip.getReservations().size() > 0 ) {
			this.trip.setState( States.PAYMENT );
		} else {
			throw new RuntimeException( "This trip must have more than 1 package to progress to the next state" );
		}
	}

	@Override
	public void accept( HashMap<String, String> stringStringHashMap ) {

	}
}

