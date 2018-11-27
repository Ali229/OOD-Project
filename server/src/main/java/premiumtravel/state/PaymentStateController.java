package premiumtravel.state;

import premiumtravel.cache.PersonRegistry;
import premiumtravel.trip.Trip;

import javax.ejb.EJB;

public abstract class PaymentStateController extends StateController {

	@EJB PersonRegistry personRegistry;

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
