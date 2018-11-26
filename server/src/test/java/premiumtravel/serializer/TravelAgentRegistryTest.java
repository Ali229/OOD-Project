package premiumtravel.serializer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import premiumtravel.people.PersonFactory;
import premiumtravel.people.TravelAgent;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Mark Zeagler
 * @version 1.0
 */
class TravelAgentRegistryTest {

	private ArrayList<TravelAgent> travelAgents = new ArrayList<>();
	private int initialSize;
	@EJB private TravelAgentRegistry travelAgentRegistry;
	@EJB private PersonFactory personFactory;

	@BeforeEach
	void setUp() {
		this.initialSize = travelAgentRegistry.getAll().size();
		for ( int i = 0; i < 10; i++ ) {
			addTravelAgent( personFactory.getTravelAgent( "firstName" + i, "lastName" + i, "phoneNumber" + i ) );
		}
	}

	@Test
	void getTravelAgents() {
		// Save the returned set, add a new travel agent, and make sure the size changes with it
		List<TravelAgent> travelAgents = travelAgentRegistry.getAll();
		addTravelAgent( personFactory.getTravelAgent( "newFirstName", "newLastName", "newPhoneNumber" ) );
		assertEquals( this.travelAgents.size() + initialSize, travelAgents.size() );

		// Make sure the returned set is unmodifiable
		assertThrows( UnsupportedOperationException.class,
				() -> personFactory.getTravelAgent( "newFirstName", "newLastName", "newPhoneNumber" ) );
	}

	@Test
	void addTravelAgent() {
		// Test that the number of agents in the registry is the number that were added in the setup
		assertEquals( this.travelAgents.size() + initialSize, travelAgentRegistry.getAll().size() );

		// Add another agent and make sure the registry size changes as well
		addTravelAgent( personFactory.getTravelAgent( "newFirstName", "newLastName", "newPhoneNumber" ) );
		assertEquals( this.travelAgents.size() + initialSize, travelAgentRegistry.getAll().size() );
	}

	private void addTravelAgent( TravelAgent travelAgent ) {
		travelAgents.add( travelAgent );
	}
}
