package premiumtravel.state;

import premiumtravel.billing.CashPayment;
import premiumtravel.people.Person;
import premiumtravel.trip.Trip;

import java.math.BigDecimal;
import java.util.HashMap;

public class CashPaymentStateController extends PaymentStateController {
	/**
	 * @param trip
	 */
	CashPaymentStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void accept( HashMap<String, String> data ) {
		if ( !data.containsKey( "person-id" ) ) {
			throw new RuntimeException( "The data must contain the key \"person-id\" and its associated value" );
		}
		String personID = data.get( "amount" );
		Person person = this.personRegistry.get( personID );
		if ( person == null ) {
			throw new RuntimeException( "The given ID does not correspond to a person in the system" );
		}
		if ( !data.containsKey( "amount" ) ) {
			throw new RuntimeException( "The data must contain the key \"amount\" and its associated value" );
		}
		BigDecimal amount = new BigDecimal( data.get( "amount" ) );
		CashPayment cashPayment = new CashPayment( amount, person );
		this.trip.getBill().submitPayment( cashPayment );
	}
}
