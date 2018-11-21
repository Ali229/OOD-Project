package premiumtravel.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.trip.Trip;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */

public class Traveller extends Person {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = 355997950295321907L;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public Trip trip;

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public PersonRegistry personRegistry;

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

