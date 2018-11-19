package premiumtravel.serializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import premiumtravel.people.Person;
import premiumtravel.trip.Trip;

import java.util.HashSet;
import java.util.Set;

/**
 * <!-- begin-user-doc --> <!--  end-user-doc  -->
 *
 * @generated
 */

public class PeopleTripsTuple {

	private static final Logger logger = LogManager.getLogger( "premiumtravel.PremiumTravelServer" );

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public final Set<Person> people = new HashSet<Person>();

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	public final Set<Trip> trips = new HashSet<Trip>();

	/**
	 * <!-- begin-user-doc --> <!--  end-user-doc  -->
	 *
	 * @generated
	 * @ordered
	 */

	PeopleTripsTuple( Set<Person> people, Set<Trip> trips ) {
		super();
		// TODO construct me
	}

}

