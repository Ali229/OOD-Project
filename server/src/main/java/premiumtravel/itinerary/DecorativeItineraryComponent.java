package premiumtravel.itinerary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */

public class DecorativeItineraryComponent extends AbstractItineraryComponent {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = 7142479453174264065L;

	private String decoration;

	/**
	 *
	 */
	public DecorativeItineraryComponent( ItineraryComponent priorDecoration, String decoration ) {
		super( priorDecoration );
		this.decoration = decoration;
	}

	@Override
	public String getItinerary() {
		return this.precedingComponent.getItinerary() + "\n" + decoration;
	}
}

