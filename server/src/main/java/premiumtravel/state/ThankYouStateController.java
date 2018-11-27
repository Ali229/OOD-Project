package premiumtravel.state;

import premiumtravel.trip.Trip;

import java.util.HashMap;

/**
 *
 */
public class ThankYouStateController extends StateController {

	/**
	 *
	 */
	ThankYouStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {
		if ( this.trip.getThankYouNote() != null ) {
			this.trip.setState( States.SHOW_ITINERARY );
		} else {
			throw new RuntimeException( "The thank you note has not been set yet. Unable to advance." );
		}
	}

	@Override
	public void accept( HashMap<String, String> data ) {
		if ( !data.containsKey( "thank-you-note" ) ) {
			throw new RuntimeException( "The data must contain the key \"thank-you-note\" and its associated value" );
		}
		String thankYouNote = data.get( "thank-you-note" );
		this.trip.setThankYouNote( thankYouNote );
	}
}

