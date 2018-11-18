package premiumtravel.serializer;
import java.util.HashSet;
import java.util.Set;
import premiumtravel.trip.Trip;
import premiumtravel.people.Person;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class PeopleTripsTuple
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public final Set<Person> people = new HashSet<Person>();

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public final Set<Trip> trips = new HashSet<Trip>();


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	PeopleTripsTuple(Set<Person> people, Set<Trip> trips) {
		super();
		// TODO construct me
	}

}

