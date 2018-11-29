package premiumtravel.state;

import premiumtravel.trip.Trip;

public abstract class PaymentStateController extends StateController {

	/**
	 * @param trip
	 */
	PaymentStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {
		if ( this.trip.getBill().isPaidInFull() ) {
			this.trip.setState( States.THANK_YOU );
		} else {
			throw new RuntimeException( "The bill has not yet been paid in full" );
		}
	}
}
