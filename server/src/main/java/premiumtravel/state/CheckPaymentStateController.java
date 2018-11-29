package premiumtravel.state;

import premiumtravel.billing.CheckPayment;
import premiumtravel.cache.PremiumTravelCache;
import premiumtravel.people.Person;
import premiumtravel.trip.Trip;

import java.math.BigDecimal;
import java.util.HashMap;

public class CheckPaymentStateController extends PaymentStateController {

	/**
	 * @param trip
	 */
	CheckPaymentStateController( Trip trip ) {
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
		if ( !data.containsKey( "check-number" ) ) {
			throw new RuntimeException( "The data must contain the key \"check-number\" and its associated value" );
		}
		String checkNumber = data.get( "check-number" );
		CheckPayment checkPayment = new CheckPayment( amount, person, checkNumber );
		this.trip.getBill().submitPayment( checkPayment );
	}
}
