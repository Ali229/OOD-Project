package premiumtravel.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class TravelAgentRegistry implements Serializable {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final Set<TravelAgent> travelAgents = new HashSet<>();
	private static final long serialVersionUID = 7940610817830344001L;

	/**
	 *
	 */
	private TravelAgentRegistry() {
	}

	/**
	 *
	 */
	public static Set<TravelAgent> getTravelAgents() {
		synchronized ( travelAgents ) {
			return Collections.unmodifiableSet( travelAgents );
		}
	}

	public static void addTravelAgent( TravelAgent travelAgent ) {
		synchronized ( travelAgents ) {
			travelAgents.add( travelAgent );
		}
	}
}

