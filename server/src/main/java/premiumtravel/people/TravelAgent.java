package premiumtravel.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.TravelAgentRegistry;

import javax.ejb.EJB;

/**
 *
 */
public class TravelAgent extends Person {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = -992437641860585387L;

	/**
	 * Creates a new TravelAgent and <b>automatically adds it to the {@link TravelAgentRegistry}</b>.
	 *
	 * @param firstName   The first name of the new Travel Agent.
	 * @param lastName    The last name of the new Travel Agent.
	 * @param phoneNumber The phone number of the new Travel Agent.
	 */
	TravelAgent( String firstName, String lastName, String phoneNumber ) {
		super( firstName, lastName, phoneNumber );
		logger.trace(
				String.format( "Creating new TravelAgent with first name: %s, last name: %s, and phone number: %s",
						firstName, lastName, phoneNumber ) );
	}
}

