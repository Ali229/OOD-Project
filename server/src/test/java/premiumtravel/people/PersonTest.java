package premiumtravel.people;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
class PersonTest {

	private static final String firstName = "firstName0";
	private static final String lastName = "lastName0";
	private static final String phoneNumber = "phoneNumber0";
	private static final int numIDComparisons = 100000;
	private static Person personUnderTest;

	@BeforeAll
	static void setUp() {
		personUnderTest = new Person( firstName, lastName, phoneNumber );
	}

	@Test
	void getFirstName() {
		assertEquals( firstName, personUnderTest.getFirstName() );
	}

	@Test
	void getLastName() {
		assertEquals( lastName, personUnderTest.getLastName() );
	}

	@Test
	void getPhoneNumber() {
		assertEquals( phoneNumber, personUnderTest.getPhoneNumber() );
	}

	/**
	 * Tests that each person's ID is unique to an extent (number set by {@link PersonTest#numIDComparisons})
	 */
	@Test
	void getPersonID() {
		ArrayList<Person> people = new ArrayList<>();
		for ( int i = 0; i < numIDComparisons; i++ ) {
			people.add( new Person( "firstName" + i, "lastName" + i, "phoneNumber" + i ) );
		}

		int startValue = 0;
		int period = 1000;
		ArrayList<PersonIDComparer> comparers = new ArrayList<>();

		for ( int i = 0; i < numIDComparisons; i += period ) {
			PersonIDComparer comparer = new PersonIDComparer( people, startValue, startValue + period );
			comparers.add( comparer );
			new Thread( comparer ).start();
		}

		boolean comparersComplete = false;
		while ( !comparersComplete ) {
			comparersComplete = true;
			for ( int i = 0; i < comparers.size(); i++ ) {
				PersonIDComparer comparer = comparers.get( i );
				if ( !comparer.complete ) {
					comparersComplete = false;
				} else {
					assertTrue( comparer.passed );
					comparers.remove( comparer );
					i--;
				}
			}
		}
	}

	/**
	 * Helper class to cut down on {@link PersonTest#getPersonID()} test runtime
	 */
	private class PersonIDComparer implements Runnable {

		private final ArrayList<Person> people;
		private final int startValue;
		private final int stopValue;
		private boolean passed = true;
		private boolean complete = false;

		private PersonIDComparer( ArrayList<Person> people, int startValue, int stopValue ) {
			this.people = people;
			this.startValue = startValue;
			this.stopValue = stopValue;
		}

		@Override
		public void run() {
			for ( int i = startValue; i < stopValue; i++ ) {
				Person person1 = people.get( i );
				for ( int u = i + 1; u < numIDComparisons; u++ ) {
					Person person2 = people.get( u );
					if ( person1.getPersonID().equals( person2.getPersonID() ) ) {
						// Not printing the values or offending Person instances because those don't really matter, just the occurrence
						this.passed = false;
						this.complete = true;
						return;
					}
				}
				this.complete = true;
			}
		}
	}
}
