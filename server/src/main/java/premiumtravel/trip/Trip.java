package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.RegistryObject;
import premiumtravel.cache.TravelAgentRegistry;
import premiumtravel.cache.TravellerRegistry;
import premiumtravel.people.TravelAgent;
import premiumtravel.people.Traveller;
import premiumtravel.state.StateController;
import premiumtravel.state.States;

import javax.ejb.EJB;
import java.math.BigDecimal;
import java.util.*;

/**
 *
 */
public class Trip implements Product, RegistryObject {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final Set<UUID> tripIDList = new LinkedHashSet<>();
	private static final long serialVersionUID = -6566205810191038527L;

	private final UUID tripID;

	@EJB private transient TravelAgentRegistry travelAgentRegistry;
	@EJB private transient TravellerRegistry travellerRegistry;

	private List<Reservation> reservations;
	private List<UUID> travellerIDs = new LinkedList<>();
	private UUID travelAgentID;
	private String thankYouNote;
	private States state;

	// Reinitialized by getter if null (state must be set)
	private transient StateController stateController;

	/**
	 * Creates a new Trip, organized by the given {@link TravelAgent}.
	 *
	 * @param travelAgent The agent responsible for the new trip.
	 */
	public Trip( TravelAgent travelAgent ) {
		super();
		this.state = States.ADD_TRAVELLERS;
		getStateController(); // To initialize controller
		this.travelAgentID = travelAgent.getID();

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

	public UUID getTripID() {
		return tripID;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations( List<Reservation> reservations ) {
		this.reservations = reservations;
	}

	public List<Traveller> getTravellers() {
		List<Traveller> travellers = new LinkedList<>();
		for ( UUID travellerID : this.travellerIDs ) {
			travellers.add( travellerRegistry.get( travellerID ) );
		}
		return travellers;
	}

	public void addTraveller( Traveller traveller ) {
		this.travellerIDs.add( traveller.getID() );
	}

	public TravelAgent getTravelAgent() {
		return this.travelAgentRegistry.get( this.travelAgentID );
	}

	public String getThankYouNote() {
		return thankYouNote;
	}

	public void setThankYouNote( String thankYouNote ) {
		this.thankYouNote = thankYouNote;
	}

	public States getState() {
		return state;
	}

	public void setState( States state ) {
		this.state = state;
	}

	/**
	 *
	 */
	public StateController getStateController() {
		if ( this.stateController == null ) {
			this.stateController = this.state.getStateController( this );
		}
		return this.stateController;
	}

	/**
	 *
	 */
	public BigDecimal getPrice() {
		return new BigDecimal( 0.0 );
	}

	@Override
	public UUID getID() {
		return this.tripID;
	}
}

