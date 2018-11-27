package premiumtravel.trip;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.cache.RegistryObject;
import premiumtravel.cache.TravelAgentRegistry;
import premiumtravel.people.TravelAgent;
import premiumtravel.people.Traveller;
import premiumtravel.state.AddTravelersStateController;
import premiumtravel.state.StateController;
import premiumtravel.state.States;

import javax.ejb.EJB;
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
	@EJB private TravelAgentRegistry travelAgentRegistry;
	private List<Reservation> reservations;
	private List<Traveller> travellers;
	private UUID travelAgentID;
	private String thankYouNote;
	private States state;
	private transient StateController stateController;

	/**
	 *
	 */
	public Trip( TravelAgent travelAgent ) {
		super();
		this.state = States.ADD_TRAVELLERS;
		this.stateController = new AddTravelersStateController( this );
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
		if ( this.state == States.ADD_PACKAGES ) {
			this.reservations = reservations;
		} else {
			throw new RuntimeException( "This trip is currently in the " + this.state.toString()
					+ " state and cannot have new packages added." );
		}
	}

	public List<Traveller> getTravellers() {
		return travellers;
	}

	public void setTravellers( List<Traveller> travellers ) {
		if ( this.state == States.ADD_TRAVELLERS ) {
			this.travellers = travellers;
		} else {
			throw new RuntimeException( "This trip is currently in the " + this.state.toString()
					+ " state and cannot have new travellers added." );
		}
	}

	public TravelAgent getTravelAgent() {
		return this.travelAgentRegistry.get( this.travelAgentID );
	}

	public String getThankYouNote() {
		return thankYouNote;
	}

	public void setThankYouNote( String thankYouNote ) {
		if ( this.state == States.THANK_YOU ) {
			this.thankYouNote = thankYouNote;
		} else {
			throw new RuntimeException( "This trip is currently in the " + this.state.toString()
					+ " state and cannot have a thank you note added." );
		}
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
		return this.stateController;
	}

	/**
	 *
	 */
	public double getPrice() {
		return 0.0;
	}

	@Override
	public UUID getID() {
		return this.tripID;
	}
}

