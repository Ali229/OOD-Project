package premiumtravel.state;

import premiumtravel.cache.PackageRegistry;
import premiumtravel.trip.Reservation;
import premiumtravel.trip.Trip;

import javax.ejb.EJB;
import java.util.HashMap;

/**
 *
 */
public class AddPackagesStateController extends StateController {

	@EJB private PackageRegistry packageRegistry;

	/**
	 *
	 */
	public AddPackagesStateController( Trip trip ) {
		super( trip );
	}

	@Override
	public void nextState() {
		if ( this.trip.getReservations().size() > 0 ) {
			this.trip.setState( States.SELECT_PAYMENT_TYPE );
		} else {
			throw new RuntimeException( "This trip must have more than 1 package to progress to the next state" );
		}
	}

	@Override
	public void accept( HashMap<String, String> data ) {
		if ( !data.containsKey( "package-id" ) ) {
			throw new RuntimeException( "The data must contain the key \"package-id\" and its associated value" );
		}
		String packageID = data.get( "package-id" );
		if ( !data.containsKey( "departure-date" ) ) {
			throw new RuntimeException( "The data must contain the key \"departure-date\" and its associated value" );
		}
		String departureDate = data.get( "departure-date" );
		if ( !data.containsKey( "arrival-date" ) ) {
			throw new RuntimeException( "The data must contain the key \"arrival-date\" and its associated value" );
		}
		String arrivalDate = data.get( "arrivalDate" );
		this.trip.addReservation( new Reservation( packageRegistry.get( packageID ), departureDate, arrivalDate ) );
	}
}

