package premiumtravel.itinerary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.trip.Reservation;

/**
 *
 */

public class ReservationItineraryComponent extends AbstractItineraryComponent {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = -7523351510137189431L;

	private Reservation reservation;

	/**
	 *
	 */
	public ReservationItineraryComponent( ItineraryComponent priorDecoration, Reservation reservation ) {
		super(priorDecoration);
		this.reservation = reservation;
	}

	@Override
	public String getItinerary() {
		return this.precedingComponent.getItinerary() + "\n" + reservation.toString();
	}
}

