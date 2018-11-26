package premiumtravel.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.TravellerRegistry;
import premiumtravel.trip.Trip;

import javax.ejb.EJB;

/**
 *
 */

public class Traveller extends Person {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = 355997950295321907L;

	public Trip trip;

	/**
	 * Singleton bean instantiated by Java EE
	 */
	@EJB
	private transient TravellerRegistry travellerRegistry;

	/**
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	Traveller( String firstName, String lastName, String phoneNumber ) {
		super( firstName, lastName, phoneNumber );
		logger.trace(
				String.format( "Creating new Traveller with first name: %s, last name: %s, and phone number: %s",
						firstName, lastName, phoneNumber ) );
	}
}

