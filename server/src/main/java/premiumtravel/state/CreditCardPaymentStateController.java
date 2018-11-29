package premiumtravel.state;

import premiumtravel.billing.CreditCardPayment;
import premiumtravel.cache.PremiumTravelCache;
import premiumtravel.people.Person;
import premiumtravel.trip.Trip;

import java.math.BigDecimal;
import java.util.HashMap;

public class CreditCardPaymentStateController extends PaymentStateController {

	/**
	 * @param trip
	 */
	CreditCardPaymentStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void accept( PremiumTravelCache premiumTravelCache, HashMap<String, String> data ) {
		if ( !data.containsKey( "person-id" ) ) {
			throw new RuntimeException( "The data must contain the key \"person-id\" and its associated value" );
		}
		String personID = data.get( "person-id" );
		Person person = premiumTravelCache.getPersonRegistry().get( personID );
		if ( person == null ) {
			person = premiumTravelCache.getTravellerRegistry().get( personID );
			if (person == null) {
				throw new RuntimeException( "The given ID does not correspond to a person in the system" );
			}
		}
		if ( !data.containsKey( "amount" ) ) {
			throw new RuntimeException( "The data must contain the key \"amount\" and its associated value" );
		}
		BigDecimal amount = new BigDecimal( data.get( "amount" ) );
		if ( !this.trip.getBill().getTotalPrice().equals( amount ) ) {
			throw new RuntimeException( "The amount to be paid is not the full amount of the bill" );
		}
		if ( !data.containsKey( "credit-card-number" ) ) {
			throw new RuntimeException(
					"The data must contain the key \"credit-card-number\" and its associated value" );
		}
		String creditCardNumber = data.get( "credit-card-number" );
		if ( !data.containsKey( "expiration-date" ) ) {
			throw new RuntimeException( "The data must contain the key \"expiration-date\" and its associated value" );
		}
		String expirationDate = data.get( "expiration-date" );
		CreditCardPayment creditCardPayment = new CreditCardPayment( amount, person, creditCardNumber, expirationDate );
		this.trip.getBill().submitPayment( creditCardPayment );
	}
}
