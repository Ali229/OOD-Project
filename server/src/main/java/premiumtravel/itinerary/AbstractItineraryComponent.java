package premiumtravel.itinerary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public abstract class AbstractItineraryComponent implements ItineraryComponent {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	ItineraryComponent precedingComponent;

	protected AbstractItineraryComponent( ItineraryComponent precedingComponent ) {
		this.precedingComponent = precedingComponent;
	}

	public static ItineraryComponent getBaseComponent() {
		return () -> "-- Itinerary --";
	}

	/**
	 *
	 */
	public abstract String getItinerary();
}

