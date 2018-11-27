package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.RegistryObject;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class TravelPackage implements Product, RegistryObject {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = -1692210919512291541L;

	/**
	 * Used to verify that each ID is unique.
	 */
	private transient static Set<UUID> registeredIDs = new LinkedHashSet<>();

	private final Place fromPlace;
	private final Place toPlace;
	private final TransportType transportType;
	private final int hoursOfTravelTime;
	private final BigDecimal price;

	private final UUID packageID;

	/**
	 *
	 */
	public TravelPackage( Place fromPlace, Place toPlace, TransportType transportType, int hoursOfTravelTime,
			BigDecimal price ) {
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.transportType = transportType;
		this.hoursOfTravelTime = hoursOfTravelTime;
		this.price = price;

		// Generate a new ID
		UUID generatedID = null;
		boolean idSet = false;
		while ( !idSet ) {
			try {
				generatedID = UUID.randomUUID();
				registeredIDs.add( generatedID );
				idSet = true;
			} catch ( UnsupportedOperationException e ) {
				// Do nothing
			}
		}

		this.packageID = generatedID;
	}

	/**
	 *
	 */
	public String toString() {
		// TODO implement me
		return "";
	}

	/**
	 *
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	@Override
	public UUID getID() {
		return this.packageID;
	}
}

