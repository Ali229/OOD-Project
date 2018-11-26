package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.RegistryObject;

import java.util.UUID;

/**
 *
 */
public class Place implements RegistryObject {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = 2719247150967625367L;
	public final String name;

	/**
	 *
	 */
	public Place(String name) {
		this.name = name;
	}

	@Override
	public UUID getID() {
		return null;
	}
}

