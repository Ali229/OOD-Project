package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.billing.Bill;
import premiumtravel.cache.RegistryObject;
import premiumtravel.people.TravelAgent;
import premiumtravel.people.Traveller;
import premiumtravel.state.State;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class Trip implements Product, RegistryObject {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	/**
	 *
	 */
	private static final Set<UUID> tripIDList = new LinkedHashSet<>();
	private static final long serialVersionUID = -6566205810191038527L;

	private final UUID tripID;
	public List<Reservation> reservations;
	public List<Traveller> travellers;
	public TravelAgent travelAgent;
	private String thankYouNote;
	private State state;

	/**
	 *
	 */
	public Trip() {
		super();

		// Generate a new ID
		UUID generatedID = null;
		boolean idSet = false;
		while ( !idSet ) {
			try {
				generatedID = UUID.randomUUID();
				tripIDList.add( generatedID );
				idSet = true;
			} catch ( UnsupportedOperationException e ) {
				// Do nothing
			}
		}

		this.tripID = generatedID;
	}

	/**
	 *
	 */
	public Bill getBill() {
		// TODO implement me
		return null;
	}

	/**
	 *
	 */
	public String getItenerary() {
		// TODO implement me
		return "";
	}

	/**
	 *
	 */
	public int getTripID() {
		// TODO implement me
		return 0;
	}

	/**
	 *
	 */
	public String getThankYouNote() {
		// TODO implement me
		return "";
	}

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public TravelAgent getTravelAgent() {
		// TODO implement me
		return null;
	}

	/**
	 *
	 */
	public List<Traveller> getTravellers() {
		// TODO implement me
		return null;
	}

	/**
	 *
	 */
	public State getState() {
		// TODO implement me
		return null;
	}

	/**
	 *
	 */
	public void setState( State state ) {
		// TODO implement me
	}

	/**
	 *
	 */
	public double getPrice() {
		// TODO implement me
		return 0.0;
	}

	@Override
	public UUID getID() {
		return this.tripID;
	}
}

