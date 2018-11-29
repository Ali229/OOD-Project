package premiumtravel.state;

import premiumtravel.billing.PaymentType;
import premiumtravel.cache.PremiumTravelCache;
import premiumtravel.trip.Trip;

import java.util.HashMap;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
public class SelectPaymentStateController extends StateController {

	/**
	 * @param trip The trip that this controller controls.
	 */
	SelectPaymentStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {
		if ( this.trip.getPaymentType() == null ) {
			throw new RuntimeException( "The payment type must be set before the state can be advanced" );
		} else {
			this.trip.setState( States.PAYMENT );
		}
	}

	@Override
	public void accept( PremiumTravelCache premiumTravelCache, HashMap<String, String> data ) {
		if ( !data.containsKey( "payment-type" ) ) {
			throw new RuntimeException( "The data must contain the key \"payment-type\" and its associated value" );
		}
		PaymentType paymentType = PaymentType.valueOf( data.get( "payment-type" ) );
		this.trip.setPaymentType( paymentType );
	}
}
