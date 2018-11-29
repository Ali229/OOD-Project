package premiumtravel.itinerary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

/**
 *
 */
public class ScriptedItineraryComponent extends AbstractItineraryComponent {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = -6933005999204802281L;

	/**
	 *
	 */
	private Supplier<String> script;

	/**
	 *
	 */
	ScriptedItineraryComponent( ItineraryComponent priorDecoration, Supplier<String> script ) {
		super( priorDecoration );
	}

	@Override
	public String getItinerary() {
		return precedingComponent.getItinerary() + "\n" + script.get();
	}
}

