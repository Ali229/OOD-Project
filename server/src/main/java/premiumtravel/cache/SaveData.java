package premiumtravel.cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.people.Person;
import premiumtravel.people.TravelAgent;
import premiumtravel.people.Traveller;
import premiumtravel.trip.Trip;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class SaveData implements Serializable {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );
	private static final long serialVersionUID = 6643271873714785332L;
	public final List<Person> people;
	public final List<TravelAgent> travelAgents;
	public final List<Traveller> travellers;
	public final List<Trip> trips;

	SaveData( List<Person> people, List<TravelAgent> travelAgents, List<Traveller> travellers, List<Trip> trips ) {
		this.people = Collections.unmodifiableList( people );
		this.travelAgents = Collections.unmodifiableList( travelAgents );
		this.travellers = Collections.unmodifiableList( travellers );
		this.trips = Collections.unmodifiableList( trips );
	}
}

